package ae.fortytwo.Parser;

import java.lang.String;

import ae.fortytwo.exceptions.InvalidScenarioException;


public class Validator
{
	private final static String [] types = {"Helicopter", "Baloon", "JetPlane"};
	
	private static boolean isValidType( String input ) throws InvalidScenarioException {
		for (String type : types)
			if (type.equals(input))
				return true;
		throw new InvalidScenarioException("No type called '" + input + "'");
	}

	private static boolean isValidName( String input ) throws InvalidScenarioException {
		if (input.length() > 1 && input.length() < 6)
			return true;
		throw new InvalidScenarioException("Name length must be between 2 to 6 '" + input + "'");
	}

	// ? Longitude + 180 to -180 || 0 to 360
	// ? Latitude + 90 to -90 || 0 to 180
	private static boolean isValidCoordinate( String input, String type) throws InvalidScenarioException {
		try {
			int coord = Integer.parseInt(input);
			if (coord > 0 && coord < 10 && type.equals("Height"))
				return true;
			if (coord > -1)
				return true;
			// if (type.equals("Longitude") && coord > 0 && coord < 360 || type.equals("Latitude") && coord > 0 && coord < 180)
			// 	retrun true;
		}
		catch (Exception e) {
			throw new InvalidScenarioException("Invalid Range " + input + ": The range should be Integer '" + e.getMessage());
		}

		String range = type.equals("Height") ? "0 to 100" : "more than 0";
		throw new InvalidScenarioException("Invalid Range '" + input + "': The range of " + type + " must be between " + range);
	}

	public static int validateSimulations( String simulations ) throws InvalidScenarioException {
		int simulationsInt = -1;
		try {
			simulationsInt = Integer.parseInt(simulations);
			if (simulationsInt < 1)
			 	throw new InvalidScenarioException("The Simulation number: Positive Integer is Required");
		}
		catch (Exception e) {
			throw new InvalidScenarioException("The Simulation number: Integer is required, " + e.getMessage());
		}
		return simulationsInt;
	}

	public static String validateAirCraft( String [] aircraft ) throws InvalidScenarioException {
		try {
			if (isValidType(aircraft[0]))
				if (isValidName(aircraft[1]))
					if (isValidCoordinate(aircraft[2], "Longitude"))
						if (isValidCoordinate(aircraft[3], "Latitude"))
							if (isValidCoordinate(aircraft[4], "Height"))
								return String.join(" ", aircraft);
		}
		catch (Exception e) {
			throw new InvalidScenarioException("The Aircraft Info: Wrong Input, " + e.getMessage());
		}
		return null;
	}
}