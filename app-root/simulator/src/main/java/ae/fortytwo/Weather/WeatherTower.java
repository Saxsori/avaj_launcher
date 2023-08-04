package ae.fortytwo.Weather;

import ae.fortytwo.Weather.Tower;
import ae.fortytwo.Weather.WeatherProvider;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates coordinates) {
		return WeatherProvider.getInstance().getCurrentWeather(coordinates);
	}

	void changeWeather() {
		conditionsChanged();
	}
}