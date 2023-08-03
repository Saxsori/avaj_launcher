package ae.fortytwo.Weather;

import java.util.Random;

import ae.fortytwo.Aircraft.Coordinates;

public class WeatherProvider {
    private String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };
	
	private WeatherProvider() {}
	
    public String getCurrentWeather(Coordinates p_coordinates)
    {
        System.out.println("Coordinate " + p_coordinates);
		int index = (int) Math.abs((p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight()) % weather.length);
        return weather[index];

    }
}