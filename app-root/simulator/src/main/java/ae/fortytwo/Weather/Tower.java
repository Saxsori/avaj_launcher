package ae.fortytwo.Weather;

import java.util.ArrayList;
import java.util.List;

import ae.fortytwo.interfaces.Flyable;

public class Tower {
	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void conditionsChanged() {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).updateConditions();
		}
	}
}