package ae.fortytwo.Aircraft;

import ae.fortytwo.Aircraft.Coordinates;
import ae.fortytwo.Aircraft.Flyable;
import ae.fortytwo.Aircraft.Helicopter;
import ae.fortytwo.Aircraft.JetPlane;
import ae.fortytwo.Aircraft.Baloon;


// create an id
public class AircraftFactory {
	private static long id = 0;
    
	public static Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
	{
		switch (p_type)
		{
			case "Helicopter":
				return new Helicopter(id++, p_name, p_coordinates);
			case "JetPlane":
				return new JetPlane(id++, p_name, p_coordinates);
			case "Baloon":
				return new Baloon(id++, p_name, p_coordinates);
			default:
				return null;
		}
	}
}