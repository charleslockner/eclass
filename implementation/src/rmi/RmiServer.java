package rmi;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import view.MainViewCreator;

import javax.swing.*;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class RmiServer extends Observable implements RmiService {

    /**
     *  For time constraints, id 1 will be the admin
     *  and id 2 and 3 will be examples of the students
     */
    private static int viewerIds = 1;

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
                ro.update(o.toString(), arg);
                System.out.println(ro.getViewer());
            } catch (RemoteException e) {
                System.out
                        .println("Remote exception removing observer:" + this);
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
        WrappedObserver mo = new WrappedObserver(o);
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

            // CREATE THE GUI
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
