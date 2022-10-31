package fr.ecole.avaj.aircrafts;

import fr.ecole.avaj.Simulator;
import fr.ecole.avaj.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		switch (weather) {
			case "SUN" -> {
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
				Simulator.logs.add(this + ": " + "This is hot.");
			}
			case "RAIN" -> {
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
				Simulator.logs.add(this + ": " + "It's raining. Better watch out for lightings.");
			}
			case "FOG" -> {
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
				Simulator.logs.add(this + ": Can't see anything, 7uck1ng hell!");
			}
			case "SNOW" -> {
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
				Simulator.logs.add(this + ": Winter is coming");
			}
			default -> {
			}
		}
		if (coordinates.getHeight() == 0) {
			Simulator.logs.add(this + " landing.");
			weatherTower.unregister(this);
		}
	}

	@Override
	public void registerTower(WeatherTower WeatherTower) {
		weatherTower = WeatherTower;
		weatherTower.register(this);
	}

	@Override
	public String toString() {
		return "JetPlane#" + name + '(' + id + ") [" + coordinates + "]";
	}
}
