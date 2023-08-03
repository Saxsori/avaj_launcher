package ae.fortytwo.Parser.POJO;

import java.util.Deque;
import java.util.ArrayDeque;

public class Scenario
{
	private int simulations;
	private Deque<String> aircrafts = new ArrayDeque<>();

	public Scenario (int simulations, Deque<String> aircrafts) {
		this.simulations = simulations;
		this.aircrafts = aircrafts;
	}

	public int getSimulations() {
		return this.simulations;
	}

	public Deque<String> getAircrafts() {
		return this.aircrafts;
	}

	public void setSimulations(int simulations) {
		this.simulations = simulations;
	}

	public void setAircrafts(Deque<String> aircrafts) {
		this.aircrafts = aircrafts;
	}

	public void addAircraft(String aircraft) {
		this.aircrafts.push(aircraft);
	}

	public void removeAircraft(String aircraft) {
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
		for (String aircraft : this.aircrafts) {
			scenario += aircraft + "\n";
		}
		return scenario;
	}
}