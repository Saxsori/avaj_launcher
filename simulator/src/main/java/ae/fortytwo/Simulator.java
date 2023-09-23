package ae.fortytwo;

import java.util.ArrayList;

import ae.fortytwo.Weather.WeatherTower;
import ae.fortytwo.Parser.Scenario;
import ae.fortytwo.Aircraft.Coordinates;
import ae.fortytwo.Aircraft.Interface.Flyable;
import ae.fortytwo.Aircraft.AircraftFactory;
import ae.fortytwo.Aircraft.Interface.Info;

public class Simulator {
    private WeatherTower weatherTower;
    
    public Simulator () {
        weatherTower = new WeatherTower();
        this.setup();
    }

    private void setup () {
        for (Info info : Scenario.getInstance().getAircrafts())
        {
            Flyable newAircraft = AircraftFactory.newAircraft(info.getType(), info.getName(), info.getCoordinates());
            newAircraft.registerTower(weatherTower);
            weatherTower.register(newAircraft);
        }
    }

    public void launch () {
        int times = Scenario.getInstance().getSimulations() + 1;
        while (--times > 0) {
            // System.out.println("->" + times);
            weatherTower.changeWeather();
        }
    }

}