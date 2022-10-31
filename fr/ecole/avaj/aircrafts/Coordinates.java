package fr.ecole.avaj.aircrafts;

import fr.ecole.avaj.exceptions.IncorrectScenarioFormatException;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int longitude, int latitude, int height) {
		if (height < 0) { height = 0; }
		if (height > 100) { height = 100; }
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	public int getLongitude() {
		return longitude;
	}

	public int getLatitude() {
		return latitude;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return longitude + " " + latitude + ", height: " + height;
	}
}
