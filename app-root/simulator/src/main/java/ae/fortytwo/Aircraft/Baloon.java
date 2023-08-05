package ae.fortytwo.Aircraft;

import ae.fortytwo.Aircraft.Aircraft;
import ae.fortytwo.Aircraft.Coordinates;
import java.util.HashMap;
import java.util.Map;

/*
◦ SUN - Longitude increases with 2, Height increases with 4
◦ RAIN - Height decreases with 5
◦ FOG - Height decreases with 3
◦ SNOW - Height decreases with 15
*/
public class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

    @Override
	public void updateConditions () {
		super.setMsg(Map.of(
            "SNOW", "B snowing",
            "SUN", "B Sunning",
            "FOG", "B Fogging",
            "RAIN", "B Raining"
        ));

		super.updateConditions();

	}
    
}