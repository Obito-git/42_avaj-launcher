package fr.ecole.avaj;

import fr.ecole.avaj.aircrafts.Coordinates;

import java.util.Random;

public class WeatherProvider {
    private WeatherProvider weatherProvider;
    private static final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {}

    public WeatherProvider getProvider() {
        if (weatherProvider == null)
            return new WeatherProvider();
        return weatherProvider;
    }

    public static String getCurrentWeather(Coordinates coordinates) {
        return weather[(((new Random().nextInt(100) + 1) * coordinates.getHeight()) + coordinates.getLatitude()
                                                            + coordinates.getLongitude()) % 4];
    }
}
