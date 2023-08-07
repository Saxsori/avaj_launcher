package ae.fortytwo.Weather;

import java.util.Random;

import ae.fortytwo.Aircraft.Coordinates;

// ? Singleton pattern ? //
public class WeatherProvider {
    private String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };
	private static WeatherProvider instance;

	private WeatherProvider() {}

	public static WeatherProvider getInstance() {
		if (instance == null)
			instance = new WeatherProvider();
		return instance;
	}

    public String getCurrentWeather(Coordinates p_coordinates)
    {
		int index = (int) Math.abs((p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight()) % weather.length);
        return weather[index];
    }
}