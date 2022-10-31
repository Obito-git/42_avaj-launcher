package fr.ecole.avaj.aircrafts;

import fr.ecole.avaj.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower WeatherTower);
}
