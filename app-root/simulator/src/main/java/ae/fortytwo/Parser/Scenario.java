package ae.fortytwo.Parser;

import java.util.Deque;
import java.util.ArrayDeque;

public class Scenario
{
	private static Scenario instance;
	private int simulations;
	private Deque<String []> aircrafts;

	private Scenario () {
		this.simulations = 0;
		this.aircrafts = new ArrayDeque<>();
	}

	public int getSimulations() {
		return this.simulations;
	}

	public Deque<String []> getAircrafts() {
		return this.aircrafts;
	}

	public static Scenario getInstance() {
		if (instance == null)
			instance = new Scenario();
		return instance;
	}

	public void setSimulations(int simulations) {
		this.simulations = simulations;
	}

	public void addAircraft(String [] aircraft) {
		this.aircrafts.add(aircraft);
	}

	public void removeAircraft(String [] aircraft) {
		this.aircrafts.remove(aircraft);
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

	@Override
	public String toString() {
		String scenario = "simulations: " + this.simulations + "\n";
		scenario += "aircrafts: \n";
		for (String [] aircraft : this.aircrafts)
			scenario += String.join(" ", aircraft) + "\n";
		return scenario;
	}
}