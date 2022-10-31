package fr.ecole.avaj;

import fr.ecole.avaj.aircrafts.Coordinates;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getCurrentWeather(coordinates);
    }

    protected void changeWeather() {
        this.conditionsChanged();
    }
}
