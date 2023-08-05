package ae.fortytwo;

import java.util.ArrayList;

import ae.fortytwo.Weather.WeatherTower;
import ae.fortytwo.Parser.Scenario;
import ae.fortytwo.Aircraft.Coordinates;
import ae.fortytwo.Aircraft.Flyable;
import ae.fortytwo.Aircraft.AircraftFactory;
import ae.fortytwo.Aircraft.DTO.Info;





public class Simulator {
    private WeatherTower weatherTower;
    // private ArrayList <Flyable> Aircrafts;
    
    public Simulator () {
        weatherTower = new WeatherTower();
        // Aircrafts = new ArrayList<>();
        this.setup();
    }

    private void setup () {
        for (Info info : Scenario.getInstance().getAircrafts())
        {
            Flyable newAircraft = AircraftFactory.newAircraft(info.getType(), info.getName(), info.getCoordinates());
            // this.Aircrafts.add(newAircraft);
            newAircraft.registerTower(weatherTower);
            weatherTower.register(newAircraft);
        }
    }

    public void launch () {
        int times = Scenario.getInstance().getSimulations() + 1;
        while (--times > 0) {
            System.out.println("->" + times);
            weatherTower.changeWeather();
        }
    }

}