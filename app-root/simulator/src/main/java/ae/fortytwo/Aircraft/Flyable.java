package ae.fortytwo.Aircraft;

import ae.fortytwo.Weather.WeatherTower;

public abstract class Flyable {
    protected WeatherTower weatherTower;

	public abstract void updateConditions();

	public void registerTower (WeatherTower p_tower) {
		weatherTower = p_tower;
	}

	public abstract long getId ();

	public abstract String getName();

	public abstract String getType ();

}