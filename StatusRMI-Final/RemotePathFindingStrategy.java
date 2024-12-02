
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Write a description of interface RemotePathFindingStrategy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface RemotePathFindingStrategy extends Remote
{
    String determineCurrentDestination() throws RemoteException;
    void determineDestination(BinCapacity binCapacity, BatteryPercentage batteryPercentage, Map map) throws RemoteException;
}
