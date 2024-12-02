
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Write a description of class RemoteLowBatteryStrategy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RemoteBinFullStrategy extends UnicastRemoteObject implements RemotePathFindingStrategy
{
    public RemoteBinFullStrategy() throws RemoteException {
        super();
    }
    
    @Override
    public String determineCurrentDestination() throws RemoteException {  
        String selectedLocation = "Docking Station";
        return selectedLocation;
    }

    @Override
    public void determineDestination(BinCapacity binCapacity, BatteryPercentage batteryPercentage, Map map) throws RemoteException {
        map.setMapLocation("Docking Station");
    }
}
