package fr.ecole.avaj.aircrafts;

public class Aircraft {
	protected long			id;
	protected String		name;
	protected Coordinates	coordinates;
	private static long		idCounter = 1;

	protected Aircraft(String name, Coordinates coordinates) {
		this.id = nextId();
		this.name = name;
		this.coordinates = coordinates;
	}

	private static long nextId() {
		return Aircraft.idCounter++;
	}
}
