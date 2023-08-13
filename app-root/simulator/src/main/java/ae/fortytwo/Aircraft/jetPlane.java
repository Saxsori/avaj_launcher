package ae.fortytwo.Aircraft;

import java.util.Map;

import ae.fortytwo.Aircraft.Aircraft;
import ae.fortytwo.Aircraft.Coordinates;

/*
◦ SUN - Latitude increases with 10, Height increases with 2
◦ RAIN - Latitude increases with 5
◦ FOG - Latitude increases with 1
◦ SNOW - Height decreases with 7
*/
public class JetPlane extends Aircraft {
	
	public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
		super.setType("JetPlane");
	}

    @Override
	public void updateConditions () {
		super.setMsg(Map.of(
            "SNOW", "Can someone lend me a snowboard for to land?",
            "SUN", "Like the Sniper Island king up here, shooting down sunbeams.",
            "FOG", "SOS, I need a fog-dispersing fan!",
            "RAIN", "Rain ain't gonna stop me from being SUPER, even if I have to use cola-powered windshield wipers!"
        ));

		super.updateConditions();

		super.coordinates.setLatitude(super.weatherTower.getWeather(super.coordinates).equals("SUN") ? 10 :
		super.weatherTower.getWeather(super.coordinates).equals("RAIN") ? 5 :
		super.weatherTower.getWeather(super.coordinates).equals("FOG") ? 1 : 0);

		super.coordinates.setHeight(super.weatherTower.getWeather(super.coordinates).equals("SUN") ? 2 :
		super.weatherTower.getWeather(super.coordinates).equals("SNOW") ? -7 : 0);

		if (super.coordinates.getHeight() <= 0)
			super.weatherTower.unregister(this);
	}
}