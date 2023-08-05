package ae.fortytwo.Parser;

import java.util.ArrayList;
import java.lang.Integer;
import java.util.Deque;
import java.util.ArrayDeque;

import ae.fortytwo.Parser.Scenario;
import ae.fortytwo.Parser.Validator;
import ae.fortytwo.exceptions.InvalidScenarioException;

public class Parser 
{
	private ArrayList<String> lines = new ArrayList<>();
	private final char delimiter = ' ';
	private Deque<Scenario> scenarios = new ArrayDeque<>();
	public boolean isValid = false;

    public Parser ( ArrayList<String> linesStack ) {
        this.lines = linesStack;
        // System.out.println("\n here from parser constructor");
        // for (String line : this.lines)
        //     System.out.println(line);
		this.start();
    }

	private String parseSimulations( String line ) throws InvalidScenarioException {
		// System.out.println("\nHere where to parse the simulations");

		String [] parts = line.split(String.valueOf(this.delimiter));
		if (parts.length != 1) 
			throw new InvalidScenarioException("The Simulation number: Incorrect syntax, contains many strings");
		return parts[0];
	}

	public String [] parseAirCraft( String airCraft ) throws InvalidScenarioException {
		String [] info = airCraft.split(String.valueOf(' '));
		if (info.length != 5)
			throw new InvalidScenarioException("The Aircraft Info: `" + airCraft + "` is either too many or too less, Follow this syntax 'TYPE NAME LONGITUDE LATITUDE HEIGHT'");
		return info;
	}
	
	private void start() {
		// System.out.println("\nHere where to start the parse");

		try {
			// * parse the first line
			String simulations = this.parseSimulations(this.lines.remove(0));
			Scenario.getInstance().setSimulations(simulations);

			// * parse the remains
			for (String line : this.lines)
				Scenario.getInstance().addAircraft(this.parseAirCraft(line));
			
			System.out.println("\n Valid aircrafts !");
			this.isValid = true;
		}
		catch (Exception e) {
			System.err.println("\nValidator Throws an Exception !\n" + e.getMessage());
		}

	}
}