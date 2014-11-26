package rmi;

import util.roster.Classroom;
import util.roster.Viewer;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * Class the resembles an observer for the server which is a viewer.
 *
 * @author kaabdull
 */
public interface RemoteObserver extends Remote {

    void update(Object observable, Object updateMsg) throws RemoteException;
    Viewer setViewer(int id, Classroom classroom) throws RemoteException;

}
