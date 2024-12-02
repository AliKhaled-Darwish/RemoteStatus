
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Write a description of class RemoteObserverImpl here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RemoteObserverImpl extends UnicastRemoteObject implements RemoteObserver
{
    public RemoteObserverImpl() throws RemoteException {
        super();
    }

    @Override
    public void update(String notification) throws RemoteException {
        System.out.println("Received update: " + notification);
    }
}
