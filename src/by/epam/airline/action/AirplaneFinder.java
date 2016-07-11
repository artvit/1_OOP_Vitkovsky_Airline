package by.epam.airline.action;

import by.epam.airline.entity.Airplane;
import by.epam.airline.entity.Airline;

import java.util.ArrayList;
import java.util.List;

public class AirplaneFinder {
    private Airline airline;

    public AirplaneFinder(Airline airline) {
        this.airline = airline;
    }

    public List<Airplane> findByFuelConsumption(double lowerBound, double upperBound) {
        List<Airplane> result = new ArrayList<>();
        for (Airplane airplane : airline.getAirplanes()) {
            double fuelConsumption = airplane.getFuelConsumption();
            if (fuelConsumption >= lowerBound && fuelConsumption <= upperBound) {
                result.add(airplane);
            }
        }
        return result;
    }
}
