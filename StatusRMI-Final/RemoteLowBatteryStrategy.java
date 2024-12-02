
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Write a description of class RemoteLowBatteryStrategy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RemoteLowBatteryStrategy extends UnicastRemoteObject implements RemotePathFindingStrategy
{
    public RemoteLowBatteryStrategy() throws RemoteException {
        super();
    }
    
    @Override
    public String determineCurrentDestination() throws RemoteException {
        
        String selectedLocation = "Charging Stations";

        return selectedLocation;
    }

    @Override
    public void determineDestination(BinCapacity binCapacity, BatteryPercentage batteryPercentage, Map map) throws RemoteException {
        map.setMapLocation("Charging Station");
    }
}
