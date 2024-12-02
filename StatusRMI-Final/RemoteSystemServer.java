
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Write a description of interface RemoteSystemServer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface RemoteSystemServer extends Remote
{
    void addObserver(RemoteObserver observer) throws RemoteException;
    void removeObserver(RemoteObserver observer) throws RemoteException;
    void updateSystemState(int binCapacity, int batteryPercentage, String mapLocation) throws RemoteException;
    RemotePathFinding getRemotePathFinding() throws RemoteException;
}
