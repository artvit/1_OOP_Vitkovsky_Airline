package test.by.epam.airline.action;

import by.epam.airline.entity.Airplane;
import by.epam.airline.exception.WrongArgumentException;
import by.epam.airline.action.RangeAirplaneComparator;
import by.epam.airline.creator.AirplaneFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class RangeComparatorTest {
    @Test
    public void compareTest() {
        AirplaneFactory factory = new AirplaneFactory();
        try {
            Airplane testCargo = factory.createCargoAirplane("manufacturer", "model", 10000, 200, 243.6);
            Airplane testPassenger = factory.createPassengerAirplane("manufacturer", "model", 3000, 200, 264);
            Airplane testOtherPassenger = factory.createPassengerAirplane("manufacturer", "model", 3000, 300, 656);
            Comparator<Airplane> airplaneComparator = new RangeAirplaneComparator();
            Assert.assertTrue(airplaneComparator.compare(testCargo, testPassenger) > 0);
            Assert.assertTrue(airplaneComparator.compare(testPassenger, testCargo) < 0);
            Assert.assertTrue(airplaneComparator.compare(testPassenger, testOtherPassenger) == 0);
        } catch (WrongArgumentException e) {
            Assert.fail("Exceptions must not be thrown. Exception message: " + e.getMessage());
        }
    }
}
