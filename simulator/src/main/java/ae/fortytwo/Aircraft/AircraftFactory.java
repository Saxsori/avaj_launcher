package ae.fortytwo.Aircraft;

import ae.fortytwo.Aircraft.Coordinates;
import ae.fortytwo.Aircraft.Interface.Flyable;
import ae.fortytwo.Aircraft.Helicopter;
import ae.fortytwo.Aircraft.JetPlane;
import ae.fortytwo.Aircraft.Baloon;


/*
 * The Factory Design Pattern in Java employs polymorphism to 
 * create objects through a shared Interface or base class.
 */
public class AircraftFactory {
	private static AircraftFactory instance = null;
	private static long id = 0;
	
    private AircraftFactory() {}
	
	public static AircraftFactory getInstance() {
		if (instance == null)
			instance = new AircraftFactory();
		return instance;
	}

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