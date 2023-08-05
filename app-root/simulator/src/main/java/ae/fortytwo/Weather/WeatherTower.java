package ae.fortytwo.Weather;

import ae.fortytwo.Weather.Tower;
import ae.fortytwo.Weather.WeatherProvider;
import ae.fortytwo.Aircraft.Coordinates;

public class WeatherTower extends Tower {

	public WeatherTower () {}

	public String getWeather ( Coordinates coordinates) {
		return WeatherProvider.getInstance().getCurrentWeather(coordinates);
	}

	public void changeWeather() {
		conditionsChanged();
	}
}