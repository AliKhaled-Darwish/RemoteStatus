
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Write a description of class RemotePathFindingImpl here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RemotePathFindingImpl extends UnicastRemoteObject implements RemotePathFinding
{
    private RemotePathFindingStrategy strategy;

    public RemotePathFindingImpl() throws RemoteException {
        super();
        // Set a default strategy
        this.strategy = new RemoteDefaultStrategy();
    }

    @Override
    public void setStrategy(RemotePathFindingStrategy strategy) throws RemoteException {
        this.strategy = strategy;
    }

    @Override
    public void update(BinCapacity binCapacity, BatteryPercentage batteryPercentage, Map map) throws RemoteException {
        if (strategy != null) {
            strategy.determineDestination(binCapacity, batteryPercentage, map);
        }
    }
}
