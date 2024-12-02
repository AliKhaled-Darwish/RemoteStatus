
import java.rmi.RemoteException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class RemoteSystemServerImpl here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RemoteSystemServerImpl extends UnicastRemoteObject implements RemoteSystemServer
{
    private RemotePathFinding remotePathFinding;
    private List<RemoteObserver> observers;

    public RemoteSystemServerImpl() throws RemoteException {
        super();
        remotePathFinding = new RemotePathFindingImpl();
        observers = new ArrayList<>();
    }
    
    @Override
    public void removeObserver(RemoteObserver observer) throws RemoteException {
        observers.remove(observer);
    }

    @Override
    public void addObserver(RemoteObserver observer) throws RemoteException {
        observers.add(observer);
    }

    @Override
    public void updateSystemState(int binCapacity, int batteryPercentage, String mapLocation) throws RemoteException {
        // Notify observers
        String notification = "Bin Capacity: " + binCapacity + ", Battery Percentage: " + batteryPercentage + ", Map Location: " + mapLocation;
        for (RemoteObserver observer : observers) {
            observer.update(notification);
        }

        // Update the path finding
        remotePathFinding.update(new BinCapacity(binCapacity), new BatteryPercentage(batteryPercentage), new Map(mapLocation));
    }

    @Override
    public RemotePathFinding getRemotePathFinding() throws RemoteException {
        return remotePathFinding;
    }

    public static void main(String[] args) {
        try {
            RemoteSystemServer remoteSystemServer = new RemoteSystemServerImpl();

            // Create RMI Registry (if not already created)
            LocateRegistry.createRegistry(1099);

            // Export the remote object and bind it to the RMI registry
            Naming.rebind("RemoteSystemServer", remoteSystemServer);

            System.out.println("RemoteSystemServer is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
