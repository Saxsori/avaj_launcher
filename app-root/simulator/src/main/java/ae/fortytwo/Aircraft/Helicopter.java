package ae.fortytwo.Aircraft;

import java.util.HashMap;
import java.util.Map;

import ae.fortytwo.Aircraft.Aircraft;
import ae.fortytwo.Aircraft.Coordinates;

/*
◦ SUN - Longitude increases with 10, Height increases with 2
◦ RAIN - Longitude increases with 5
◦ FOG - Longitude increases with 1
◦ SNOW - Height decreases with 12
*/
public class Helicopter extends Aircraft{

    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
		super.setType("Helicopter");
	}

    @Override
	public void updateConditions () {
		super.setMsg(Map.of(
            "SNOW", "Brrr! Chopper, where's your Heavy Point? We need some fur up here !",
            "SUN", "Navigating this heat is tougher than calculating Grand Line currents!",
            "FOG", "Lost in history just like Robin in a library - I can't find the way out of this fog!",
            "RAIN", "Says we're in Nami's forecast zone! Can we get a discount on the rain rate?"
        ));

		super.updateConditions();
	
		super.coordinates.setLongitude(super.weatherTower.getWeather(super.coordinates).equals("SUN") ? 10 :
		super.weatherTower.getWeather(super.coordinates).equals("RAIN") ? 5 :
		super.weatherTower.getWeather(super.coordinates).equals("FOG") ? 1 :
		0);

		super.coordinates.setHeight(super.weatherTower.getWeather(super.coordinates).equals("SUN") ? 2 :
		super.weatherTower.getWeather(super.coordinates).equals("SNOW") ? -12 : 0);

		if (super.coordinates.getHeight() <= 0)
			super.weatherTower.unregister(this);
	}
}