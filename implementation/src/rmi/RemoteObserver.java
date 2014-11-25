package rmi;

import util.roster.Classroom;
import util.roster.Viewer;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * Created by Keithmaynn on 11/20/14.
 */
public interface RemoteObserver extends Remote {

    void update(Object observable, Object updateMsg) throws RemoteException;
    Viewer setViewer(int id, Classroom classroom) throws RemoteException;

}
