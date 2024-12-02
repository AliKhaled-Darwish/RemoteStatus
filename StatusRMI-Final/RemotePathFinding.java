
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Write a description of interface RemotePathFinding here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface RemotePathFinding extends Remote
{
    void setStrategy(RemotePathFindingStrategy strategy) throws RemoteException;
    void update(BinCapacity binCapacity, BatteryPercentage batteryPercentage, Map map) throws RemoteException;
}
