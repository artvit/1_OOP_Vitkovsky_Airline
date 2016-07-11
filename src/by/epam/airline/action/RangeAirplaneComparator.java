package by.epam.airline.action;

import by.epam.airline.entity.Airplane;

import java.util.Comparator;

public class RangeAirplaneComparator implements Comparator<Airplane> {
    @Override
    public int compare(Airplane o1, Airplane o2) {
        return Double.compare(o1.getRange(), o2.getRange());
    }
}
