
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Write a description of interface RemoteObserver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface RemoteObserver extends Remote
{
    void update(String notification) throws RemoteException;
}
