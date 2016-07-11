package by.epam.airline.creator;

import by.epam.airline.entity.CargoAirplane;
import by.epam.airline.entity.PassengerAirplane;
import by.epam.airline.exception.WrongArgumentException;

public class AirplaneFactory {
    public CargoAirplane createCargoAirplane(String manufacturer, String model, double range, double fuelCapacity, double payload) throws WrongArgumentException {
        if (range <= 0) {
            throw new WrongArgumentException("Invalid range parameter");
        }
        if (fuelCapacity <= 0) {
            throw new WrongArgumentException("Invalid fuel capacity parameter");
        }
        if (payload < 0) {
            throw new WrongArgumentException("Invalid payload parameter");
        }
        return new CargoAirplane(manufacturer, model, range, fuelCapacity, payload);
    }

    public PassengerAirplane createPassengerAirplane(String manufacturer, String model, double range, double fuelCapacity, int capacity) throws WrongArgumentException {
        if (range <= 0) {
            throw new WrongArgumentException("Invalid range parameter");
        }
        if (fuelCapacity <= 0) {
            throw new WrongArgumentException("Invalid fuel capacity parameter");
        }
        if (capacity < 0) {
            throw new WrongArgumentException("Invalid capacity parameter");
        }
        return new PassengerAirplane(manufacturer, model, range, fuelCapacity, capacity);
    }
}
