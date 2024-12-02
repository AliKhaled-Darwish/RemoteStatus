import java.io.Serializable;
/**
 * Write a description of class Map here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Map implements Serializable
{
    // instance variables - replace the example below with your own
    private String mapLocation;
    
    public Map(String mapLocation) {
        this.mapLocation = mapLocation;
    }

    public String getMapLocation() {
        return mapLocation;
    }

     public void setMapLocation(String mapLocation) {
        this.mapLocation = mapLocation;
    }
}
