package ae.fortytwo.Parser;

import java.util.Deque;
import java.util.ArrayDeque;

import ae.fortytwo.exceptions.InvalidScenarioException;
import ae.fortytwo.Aircraft.DTO.Info;
import ae.fortytwo.Aircraft.Coordinates;


// ? A Singleton POJO :)
public class Scenario
{
	private static Scenario instance;
	private int simulations;
	private Deque<Info> aircrafts;

	private Scenario () {
		this.simulations = 0;
		this.aircrafts = new ArrayDeque<>();
	}

	public int getSimulations() {
		return this.simulations;
	}

	public Deque<Info> getAircrafts() {
		return this.aircrafts;
	}

	public static Scenario getInstance() {
		if (instance == null)
			instance = new Scenario();
		return instance;
	}

	public void setSimulations(String simulations) throws InvalidScenarioException {
		this.simulations = Validator.validateSimulations(simulations);
	}

	public void addAircraft(final String [] aircraft) throws InvalidScenarioException {
		Validator.validateAirCraft(aircraft);
		this.aircrafts.add(new Info() {
            @Override
            public String getType() {
                return aircraft[0];
            }

            @Override
            public String getName() {
                return aircraft[1];
            }

            @Override
            public Coordinates getCoordinates() {
                return  new Coordinates(
					Integer.parseInt(aircraft[2]), 
					Integer.parseInt(aircraft[3]),
					Integer.parseInt(aircraft[4]));
            }
        });
	}

	public void removeAircraft(int index) {
		this.aircrafts.remove(index);
	}

	public void removeAircraft() {
		this.aircrafts.pop();
	}

	public void clearAircrafts() {
		this.aircrafts.clear();
	}

	// @Override
	// public String toString() {
	// 	String scenario = "simulations: " + this.simulations + "\n";
	// 	scenario += "aircrafts: \n";
	// 	for (String [] aircraft : this.aircrafts)
	// 		scenario += String.join(" ", aircraft) + "\n";
	// 	return scenario;
	// }
}