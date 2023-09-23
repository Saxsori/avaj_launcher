package ae.fortytwo.Aircraft.Interface;

import ae.fortytwo.Weather.WeatherTower;

public abstract class Flyable {
	/* 
		Aggregation is a relationship where one class (the whole) 
		has a reference to another class (the part), but the part can exist 
		independently of the whole.
	*/
    protected WeatherTower weatherTower;

	public abstract void updateConditions();

	public void registerTower (WeatherTower p_tower) {
		weatherTower = p_tower;
	}

	public abstract long getId ();

	public abstract String getName();

	public abstract String getType ();

}