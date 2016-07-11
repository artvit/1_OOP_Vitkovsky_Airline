package by.epam.airline.action;

import by.epam.airline.entity.Airplane;
import by.epam.airline.entity.CargoAirplane;
import by.epam.airline.entity.Airline;

public class CargoCounter {
    public static double countTotalPayload(Airline airline) {
        double sum = 0;
        for (Airplane airplane : airline.getAirplanes()) {
            if (airplane instanceof CargoAirplane) {
                sum += ((CargoAirplane) airplane).getPayload();
            }
        }
        return sum;
    }
}
