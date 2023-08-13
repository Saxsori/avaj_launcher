package ae.fortytwo.Aircraft;

import java.util.HashMap;
import java.util.Map;

import ae.fortytwo.Aircraft.Aircraft;
import ae.fortytwo.Aircraft.Coordinates;

/*
◦ SUN - Longitude increases with 2, Height increases with 4
◦ RAIN - Height decreases with 5
◦ FOG - Height decreases with 3
◦ SNOW - Height decreases with 15
*/
public class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
		super.setType("Baloon");
	}

    @Override
	public void updateConditions () {
		super.setMsg(Map.of(
            "SNOW", "Ice age alert! I'm in the sky, but it's colder than Aokiji's heart out here!",
            "SUN", "My crew's melting like ice cream! Call Kuzan to chill this place!",
            "FOG", "Is that you, Caesar Clown? The weather's playing tricks again !",
            "RAIN", "I feel like I'm singing 'Bink's Sake' in this downpour!"
        ));

		super.updateConditions();

		super.coordinates.setLongitude(super.weatherTower.getWeather(super.coordinates).equals("SUN") ? 2 : 0);

		super.coordinates.setHeight(super.weatherTower.getWeather(super.coordinates).equals("SUN") ? 4 :
		super.weatherTower.getWeather(super.coordinates).equals("RAIN") ? -5 :
		super.weatherTower.getWeather(super.coordinates).equals("FOG") ? -3 :
		super.weatherTower.getWeather(super.coordinates).equals("SNOW") ? -15 : 0);


		if (super.coordinates.getHeight() <= 0)
			super.weatherTower.unregister(this);
	}
    
}