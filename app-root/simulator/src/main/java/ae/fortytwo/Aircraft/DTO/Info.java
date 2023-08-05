package ae.fortytwo.Aircraft.DTO;

import ae.fortytwo.Aircraft.Coordinates;

public interface Info {
    String getType();
    String getName();
    Coordinates getCoordinates();
}