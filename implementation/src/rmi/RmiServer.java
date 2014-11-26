package rmi;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import util.roster.Classroom;
import util.roster.Viewer;
import view.MainViewCreator;
import javax.swing.*;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class RmiServer extends Observable implements RmiService {

    private DB db;

    private static final long serialVersionUID = 1L;

    /**
     *  For time constraints, id 0 will be the admin
     *  and id 1 and 2 will be examples of the students
     */
    private static int viewerIds = 0;

    /**
     *
     * The server will keep track of a classroom.
     * For time constraints - we'll resemble just a single class.
     *
     */
    private Classroom classroom = new Classroom("CSC 307");


    public Map<String, Viewer> viewerIntegerMap = new HashMap<String, Viewer>();




    /**
     * Controlling the gui elements through the server
     */
    public static MainViewCreator viewCreator = new MainViewCreator();


    private class WrappedObserver implements Observer, Serializable {

        private static final long serialVersionUID = 1L;

        private RemoteObserver ro = null;

        public WrappedObserver(RemoteObserver ro) {
            this.ro = ro;
        }


        /**
         * this is the method that is called when we call notifyObserver
         * arg - is the string or any object being passed as a parameter of notifyObserver(param1)
         *
         * @param o the observable object or the viewer
         * @param arg what we are passing back to the viewer
         */
        @Override
        public void update(Observable o, Object arg) {
            try {
                // the message being sent over to the client
                ro.update(o.toString(), arg);
            } catch (RemoteException e) {

                System.out.println("Remote exception removing observer:" + this);

                Viewer viewer = viewerIntegerMap.get(this.toString());

                // update viewers view status to false
                viewer.updateViewer(viewer.getId(), db, "currentlyInClass", "false");
                // remove them from their classroom
                classroom.removeViewerFromCurrentSession(viewer);

                o.deleteObserver(this);

            }
        }

    }



    /**
     *
     * Adding observers is like adding viewers to an application
     *
     * @param o the object or viewer that we are adding to the app
     * @throws RemoteException
     */
    @Override
    public void addObserver(RemoteObserver o) throws RemoteException {

        // create the viewer, add them to the classroom
        // then add the viewer to the servers viewer database collection
        Viewer viewer = o.setViewer(viewerIds++, classroom);

        WrappedObserver mo = new WrappedObserver(o);

        viewerIntegerMap.put(mo.toString(), viewer);
        addObserver(mo);


        System.out.println("Added observer:" + mo);
    }

    Thread thread = new Thread() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                    // ignore
                }
                setChanged();
                notifyObservers(new Date());
            }
        };
    };

    public RmiServer() {

        // this should be fired off once for each client
        try {
            // talk to mongo
            MongoClientURI mongoClientURI =
                    new MongoClientURI("mongodb://kaabdull:eclass@ds055680.mongolab.com:55680/eclassroom");
            // establish the connection as an actual client now
            MongoClient mongoClient = new MongoClient(mongoClientURI);
            // find the database
            this.db = mongoClient.getDB("eclassroom");
        } catch( UnknownHostException e) {
            System.err.println("Unkown Host Exception : " + e);
        }

        thread.start();
    }

    /**
     *
     * This starts the Electric Classrooms Server
     *
     * @param args n/a
     */
    public static void main(String[] args) {
        try {        	
            // CREATE THE MODEL AND GUI
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    //Turn off metal's use of bold fonts
                    UIManager.put("swing.boldMetal", Boolean.FALSE);

                    viewCreator.createAndShowGUI();
                }
            });

            /**
             *
             * Basically this section is creating a connection at port 1099 and encapsulate it into
             * a registry. Think of it as a box of listeners, but we are turn all listeners off except the one
             * listening to port 1099.
             *
             * - we create our rmi server object and store it in this box of listeners
             * - then whenever a client asks to bind to the box to start using the application
             *      - the client must create a instance of service
             *      - look service up by 'RmiService'
             *      - use the method from RmiServer (addObserver) inside of the client to add itself to the server
             *
             */
            Registry rmiRegistry = LocateRegistry.createRegistry(1099);
            RmiService rmiService = (RmiService) UnicastRemoteObject
                    .exportObject(new RmiServer(), 1099);
            rmiRegistry.bind("RmiService", rmiService);


            System.out.println("server is ready...");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
