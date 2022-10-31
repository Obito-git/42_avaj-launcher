package fr.ecole.avaj;

import fr.ecole.avaj.aircrafts.AircraftFactory;
import fr.ecole.avaj.aircrafts.Flyable;
import fr.ecole.avaj.exceptions.IncorrectScenarioFormatException;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Simulator {
	private static ArrayList<Flyable> aircrafts = new ArrayList<>();
	private static int simulationTimes;
	public static ArrayList<String> logs = new ArrayList<>();

	private static void parseFile(BufferedReader reader) throws IOException, IncorrectScenarioFormatException {
		String s = reader.readLine();
		long current_line = 2;
		try {
			simulationTimes = Integer.parseInt(s);
			if (simulationTimes < 0)
				throw new RuntimeException();
		} catch (NullPointerException e) {
			throw new IncorrectScenarioFormatException("File is empty");
		} catch (RuntimeException e) {
			throw new IncorrectScenarioFormatException("Positive integer number expected at line 1");
		}
		while ((s = reader.readLine()) != null) {
			String[] val = s.split(" ");
			if (val.length != 5)
				throw new IncorrectScenarioFormatException("Incorrect aircraft description at line "
						+ (current_line) + ", TYPE NAME LONGITUDE LATITUDE HEIGHT expected");
			try {
				int longitude = Integer.parseInt(val[2]);
				int latitude = Integer.parseInt(val[3]);
				int height = Integer.parseInt(val[4]);
				if (longitude < 0 || latitude < 0)
					throw new IncorrectScenarioFormatException("Coordinates: Longitude and latitude must be positive integer numbers");
				aircrafts.add(AircraftFactory.newAircraft(val[0], val[1], longitude, latitude, height));
			} catch (RuntimeException e) {
				throw new IncorrectScenarioFormatException("LONGITUDE LATITUDE HEIGHT must be a numbers at line " + current_line);
			}
			current_line++;
		}
	}

	static void simulate() {
		WeatherTower tower = new WeatherTower();
		aircrafts.forEach((element) -> element.registerTower(tower));
		while (simulationTimes != 0) {
			tower.changeWeather();
			simulationTimes--;
		}
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Wrong args count");
			return;
		}
		try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
			parseFile(reader);
			simulate();
			try (FileWriter writer = new FileWriter("simulation.txt", false)) {
				for (String s: logs)
					writer.write(s + "\n");
			} catch (IOException e) {
				System.out.println("Can't write result in simulation.txt");
			}
		} catch (IOException e) {
			System.out.println("Can't open " + args[0]);
		} catch (IncorrectScenarioFormatException e) {
			System.out.println(e.getMessage());
		}
	}
}
