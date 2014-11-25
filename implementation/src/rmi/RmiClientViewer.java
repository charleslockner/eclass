package rmi;


import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import util.roster.Viewer;
import view.MainViewCreator;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.UnknownHostException;
import java.rmi.server.UnicastRemoteObject;

public class RmiClientViewer extends UnicastRemoteObject implements RemoteObserver {

    private Viewer viewer;
    private DB db;


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
                    // connect to the viewer database
            DBCollection collection = db.getCollection("viewers");
        } catch( UnknownHostException e) {
            System.err.println("Unkown Host Exception : " + e);
        }

    }




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

    @Override
    public Viewer getViewer(int id) {
        viewer = new Viewer();
        //viewer.unmarshallViewerDataFromServer(id, db);
        return viewer;
    }


    @Override
    public void update(Object observable, final Object updateMsg)
            throws RemoteException {
        System.out.println("got message:" + updateMsg);
    }


}