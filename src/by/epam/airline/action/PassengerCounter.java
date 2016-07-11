package by.epam.airline.action;

import by.epam.airline.entity.Airplane;
import by.epam.airline.entity.PassengerAirplane;
import by.epam.airline.entity.Airline;

public class PassengerCounter {
    public static int countTotalCapacity(Airline airline) {
        int sum = 0;
        for (Airplane airplane : airline.getAirplanes()) {
            if (airplane instanceof PassengerAirplane) {
                sum += ((PassengerAirplane) airplane).getCapacity();
            }
        }
        return sum;
    }
}
