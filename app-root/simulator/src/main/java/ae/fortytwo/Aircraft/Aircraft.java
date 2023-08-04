package ae.fortytwo.Aircraft;

import ae.fortytwo.Aircraft.Coordinates;
import ae.fortytwo.interfaces.Flyable;

public class Aircraft extends Flyable{
    protected long id;
	protected String name;
	protected Coordinates coordinates;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
		this.name = p_name;
		this.coordinates = p_coordinates;
		this.id = p_id;
	}
}