package fr.ecole.avaj;

import fr.ecole.avaj.aircrafts.Flyable;

import java.util.ArrayList;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        if (!observers.contains(flyable)) {
            observers.add(flyable);
            Simulator.logs.add("Tower says: " + flyable + " registered to weather tower.");
        }
    }

    public void unregister(Flyable flyable) {
        if (observers.remove(flyable))
            Simulator.logs.add("Tower says: " + flyable + " unregistered from weather tower.");
    }

   protected void conditionsChanged() {
        for (int i = 0; i < observers.size(); i++)
            observers.get(i).updateConditions();
   }
}
