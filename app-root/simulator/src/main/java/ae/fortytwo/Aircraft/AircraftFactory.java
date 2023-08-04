package ae.fortytwo.Aircraft;

import ae.fortytwo.Aircraft.Coordinates;
import ae.fortytwo.interfaces.Flyable;

// create an id
public class AircraftFactory {
	private static long id = 0;
    public Flyable* newAircraft(String p_type, String p_name, Coordinates p_coordinates)
	{

		switch (p_type)
		{
			case "Helicopter":
				return new Helicopter(p_name, p_coordinates);
			case "JetPlane":
				return new JetPlane(p_name, p_coordinates);
			case "Baloon":
				return new Baloon(p_name, p_coordinates);
			default:
				return null;
		}
	}
}