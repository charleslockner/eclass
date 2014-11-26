package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface for the server to implement.
 *
 * @author kaabdull
 */
public interface RmiService extends Remote {

    /**
     *
     * When server is starting up, add a remote observer or a client to the connection
     *
     * @param o the client or the observer attaching to the servers port
     * @throws RemoteException throw an exeception if anything goes wrong
     */
    void addObserver(RemoteObserver o) throws RemoteException;

}