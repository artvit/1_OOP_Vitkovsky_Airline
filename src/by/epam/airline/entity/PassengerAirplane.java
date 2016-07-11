package by.epam.airline.entity;

import java.util.Objects;

public class PassengerAirplane extends Airplane {
    private int capacity;

    public PassengerAirplane(String manufacturer, String model, double range, double fuelCapacity, int capacity) {
        super(manufacturer, model, range, fuelCapacity);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return super.toString() + " Capacity: " + capacity + "ppl";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof PassengerAirplane)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        PassengerAirplane that = (PassengerAirplane) o;
        return getCapacity() == that.getCapacity();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCapacity());
    }
}
