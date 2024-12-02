
import java.rmi.Naming;

/**
 * Write a description of class RemoteSystemClient here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RemoteSystemClient
{
    public static void main(String[] args) {
        try {
            RemoteSystemServer remoteSystemServer = (RemoteSystemServer) Naming.lookup("rmi://localhost/RemoteSystemServer");
            RemoteObserver observer = new RemoteObserverImpl();
            remoteSystemServer.addObserver(observer);

            RemotePathFinding remotePathFinding = remoteSystemServer.getRemotePathFinding();

            BinCapacity binCapacity = new BinCapacity(10);  // Initial binCapacity
            BatteryPercentage batteryPercentage = new BatteryPercentage(90);  // Initial batteryPercentage
            RemotePathFindingStrategy strategy = new RemoteDefaultStrategy();
            
            for (int i = 0; i < 5; i++) {
                
                if (binCapacity.getBinCapacity() >= 70) {
                    strategy = new RemoteBinFullStrategy();
                } else if (batteryPercentage.getBatteryPercentage() < 30) {
                    strategy = new RemoteLowBatteryStrategy();
                } else{
                    strategy = new RemoteDefaultStrategy();
                }

                remotePathFinding.setStrategy(strategy);
                String mapLocation = strategy.determineCurrentDestination();
                binCapacity.setBinCapacity(binCapacity.getBinCapacity() + 20);
                batteryPercentage.setBatteryPercentage(Math.max(0, batteryPercentage.getBatteryPercentage() - 15));
                

                remoteSystemServer.updateSystemState(binCapacity.getBinCapacity(),batteryPercentage.getBatteryPercentage(), mapLocation);
                // Sleep to simulate time passing between updates
                Thread.sleep(1000);
            }
            remoteSystemServer.removeObserver(observer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
