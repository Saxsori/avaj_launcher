package ae.fortytwo.Aircraft;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates (int p_logitude, int p_latitude, int p_height)
    {
        this.longitude = p_logitude;
        this.latitude = p_latitude;
        this.height = p_height;
    }

    public int getLongitude () {
        return this.longitude;
    }

    public int getLatitude () {
        return this.latitude;
    }

    public int getHeight () {
        return this.height;
    }

	public void setLongitude (int longitude) {
        this.longitude += longitude;
    }

    public void setLatitude (int latitude) {
        this.latitude += latitude;
    }

    public void setHeight (int height) {
        this.height += height;
    }

	@Override
	public String toString() {
		return "Coordinates [height=" + height + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
}