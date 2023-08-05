package ae.fortytwo.Aircraft;

import ae.fortytwo.Aircraft.Aircraft;
import ae.fortytwo.Aircraft.Coordinates;
import java.util.Map;
/*
◦ SUN - Latitude increases with 10, Height increases with 2
◦ RAIN - Latitude increases with 5
◦ FOG - Latitude increases with 1
◦ SNOW - Height decreases with 7
*/
public class JetPlane extends Aircraft {
	
	public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

    @Override
	public void updateConditions () {
		super.setMsg(Map.of(
            "SNOW", "J snowing",
            "SUN", "J Sunning",
            "FOG", "J Fogging",
            "RAIN", "J Raining"
        ));

		super.updateConditions();

	}
}