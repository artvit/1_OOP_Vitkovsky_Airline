package by.epam.airline.action;

import by.epam.airline.action.RangeAirplaneComparator;
import by.epam.airline.entity.Airplane;
import by.epam.airline.entity.Airline;

import java.util.Collections;
import java.util.List;

public class AirlineSorter {
    public static void sortByRange(Airline airline) {
        List<Airplane> airplanes = airline.getAirplanes();
        Collections.sort(airplanes, new RangeAirplaneComparator());
        airline.setAirplanes(airplanes);
    }
}
