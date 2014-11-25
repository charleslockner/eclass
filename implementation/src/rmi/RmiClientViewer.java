package rmi;

import util.roster.Viewer;
import view.MainViewCreator;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiClientViewer extends UnicastRemoteObject implements RemoteObserver {

    private Viewer viewer;

    protected RmiClientViewer() throws RemoteException {
        super();

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
        viewer.unmarshallViewerDataFromServer(id);
        return viewer;
    }


    @Override
    public void update(Object observable, final Object updateMsg)
            throws RemoteException {
        System.out.println("got message:" + updateMsg);
    }


}