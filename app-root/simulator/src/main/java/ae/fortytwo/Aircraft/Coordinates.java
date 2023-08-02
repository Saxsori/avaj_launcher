package ae.fortytwo.Aircraft;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates (int p_logitude, int p_latitude, int p_height)
    {
        this.longitude = p_logitude;
        this.latitude = p_latitude;
        this.height = p_height;
    }

    int getLongitude () {
        return this.longitude;
    }

    int getLatitude () {
        return this.latitude;
    }

    int getHeight () {
        return this.height;
    }
}