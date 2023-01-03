package fr.ecole.avaj;

import fr.ecole.avaj.aircrafts.Coordinates;

import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        return WeatherProvider.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return weather[(((new Random().nextInt(100) + 1) * coordinates.getHeight()) + coordinates.getLatitude()
                                                            + coordinates.getLongitude()) % 4];
    }
}
