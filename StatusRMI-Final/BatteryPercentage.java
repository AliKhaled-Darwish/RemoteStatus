import java.io.Serializable;

/**
 * Write a description of class BatteryPercentage here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BatteryPercentage implements Serializable
{
    // instance variables - replace the example below with your own
    private int batteryPercentage;
    
    public BatteryPercentage(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }
   
     public int getBatteryPercentage() {
        return batteryPercentage;
    }

    
    public void setBatteryPercentage(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }
}
