import java.io.Serializable;

/**
 * Write a description of class BinCapacity here.
 *
 * @author (Ali Darwish)
 * @version (1.0)
 */
public class BinCapacity implements Serializable
{
    // instance variables - replace the example below with your own
    private int binCapacity;
    
    public BinCapacity(int binCapacity) {
        this.binCapacity = binCapacity;
    }
    
    public int getBinCapacity() {
        return binCapacity;
    }

    public void setBinCapacity(int binCapacity) {
        this.binCapacity = binCapacity;
    }
    
}
