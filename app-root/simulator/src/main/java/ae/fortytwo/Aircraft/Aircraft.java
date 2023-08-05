package ae.fortytwo.Aircraft;

import ae.fortytwo.Aircraft.Coordinates;
import ae.fortytwo.Aircraft.Flyable;
import java.util.HashMap;
import java.util.Map;

public class Aircraft extends Flyable{
    protected long id;
	protected String name;
	protected Coordinates coordinates;
	private Map<String, String> msg;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
		this.name = p_name;
		this.coordinates = p_coordinate;
		this.id = p_id;
        msg = new HashMap<String, String>() {{
            put("SNOW", "");
            put("SUN", "");
            put("RAIN", "");
            put("FOG", "");
        }};
	}

	@Override
	public void updateConditions () {
		switch (super.weatherTower.getWeather(this.coordinates)) {
			case "SNOW":
				System.out.println(this.name + " " + this.msg.get("SNOW"));
				break ;
			case "FOG":
				System.out.println(this.name + " " + this.msg.get("FOG"));
				break ;
			case "RAIN":
				System.out.println(this.name + " " + this.msg.get("RAIN"));
				break ;
			case "SUN":
				System.out.println(this.name + " " + this.msg.get("SUN"));
				break ;
			default :
				System.out.println(this.name + " voooooo !");
				break ;
		}
	}

	protected long getId () {
		return this.id;
	}

	protected String getName () {
		return this.name;
	}

	protected Coordinates getCoordinates () {
		return this.coordinates;
	}

	protected void setName (String name) {
		this.name = name;
	}

	protected void setCoordinates (Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	protected void setMsg (Map<String, String> msg) {
	  	this.msg.clear();
        this.msg.putAll(msg);
	}

}