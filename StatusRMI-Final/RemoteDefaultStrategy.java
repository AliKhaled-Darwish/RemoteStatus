
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Write a description of class RemoteDefaultStrategy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RemoteDefaultStrategy extends UnicastRemoteObject implements RemotePathFindingStrategy
{
    private List<String> defaultLocations;
    private Random random;

    public RemoteDefaultStrategy() throws RemoteException {
        super();
        // Initialize default locations
        defaultLocations = new ArrayList<>();
        defaultLocations.add("Living Room");
        defaultLocations.add("Master Bedroom");
        defaultLocations.add("Bathroom");
        defaultLocations.add("Kitchen");
        defaultLocations.add("Boy Bedroom");
        defaultLocations.add("Girl Bedroom");

        // Initialize random number generator
        random = new Random();
    }
    
    @Override
    public String determineCurrentDestination() throws RemoteException {
        // Randomly select a default location
        String selectedLocation = defaultLocations.get(random.nextInt(defaultLocations.size()));

        return selectedLocation;
    }

    @Override
    public void determineDestination(BinCapacity binCapacity, BatteryPercentage batteryPercentage, Map map) throws RemoteException {
        // Randomly select a default location
        String selectedLocation = defaultLocations.get(random.nextInt(defaultLocations.size()));

        map.setMapLocation(selectedLocation);
    }
}
