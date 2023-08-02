package ae.fortytwo.Weather;

import ae.fortytwo.Aircraft.Coordinates;

public class WeatherProvider {
    private String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };
    private WeatherProvider()
    {
        
    }
    public String getCurrentWeather(Coordinates p_coordinates)
    {
        System.out.println("Coordinate " + p_coordinates);
        return null;
    }
}