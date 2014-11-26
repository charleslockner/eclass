package rmi;


import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import util.roster.Classroom;
import util.roster.Viewer;
import view.MainViewCreator;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.UnknownHostException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * This class implements a client, which is a viewer.
 * @author kaabdull
 */
public class RmiClientViewer extends UnicastRemoteObject implements RemoteObserver {

    private Viewer viewer;
    private DB db;
    private static final long serialVersionUID = 1L;


    /**
     *
     * Constructor for the client creation and make an instance of mongo
     *
     * @throws RemoteException
     */
    protected RmiClientViewer() throws RemoteException {
        super();


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

    }


    /**
     *
     * Main connects client to the server.
     * Adds an instance of the client to the server.
     * Then generates the graphical user interface of eclassroom
     *
     * @param args  n/a not used here
     */
    public static void main(String[] args) {

        /**
         *
         * This is where we talk about how the client is making the instance of the
         * remote server or service. Then calling the remote servers method addObserver
         * to add itself (the client) to the server.
         *
         * (Remember you have instance of the server) - but can't communicate back to it yet
         *
         * Think about the client saying, "Hey server I am trying to connect." If client asks the right
         * server then they can connect. Then in order for the server to update the client, the server
         * must have an instance of client to update ITS PROPERTIES.
         *
         *
         */
        try {
            RmiService remoteService = (RmiService) Naming
                    .lookup("RmiService");

            RmiClientViewer client = new RmiClientViewer();
            remoteService.addObserver(client);

            new MainViewCreator().createAndShowGUI();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }



    /**
     *
     * This server sets the user and adds them to the classroom
     *
     * @param id  the id of the viewer
     * @param classroom  the classroom that the viewer will be added to
     * @return the viewer
     */
    @Override
    public Viewer setViewer(int id, Classroom classroom) {
        this.viewer = new Viewer();
        viewer.unmarshallViewerDataFromServer(id, db);
        classroom.addViewerToCurrentSession(viewer);
        return viewer;
    }


    /**
     *
     * The method that is used to talk from the server to the client.
     * Wish I had more time to implement
     *
     * @param observable
     * @param updateMsg the message being sent
     * @throws RemoteException
     */
    @Override
    public void update(Object observable, final Object updateMsg)
            throws RemoteException {
        System.out.println("got message:" + updateMsg);
    }


}