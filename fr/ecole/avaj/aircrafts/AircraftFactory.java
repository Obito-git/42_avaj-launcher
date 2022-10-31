package fr.ecole.avaj.aircrafts;

import fr.ecole.avaj.exceptions.IncorrectScenarioFormatException;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws IncorrectScenarioFormatException {
        return switch (type) {
            case "Baloon" -> new Baloon(name, new Coordinates(longitude, latitude, height));
            case "Helicopter" -> new Helicopter(name, new Coordinates(longitude, latitude, height));
            case "JetPlane" -> new JetPlane(name, new Coordinates(longitude, latitude, height));
            default -> throw new IncorrectScenarioFormatException(type + " is unknown aircraft type");
        };
    }
}
