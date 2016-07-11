package by.epam.airline.entity;

import java.util.Objects;

public class CargoAirplane extends Airplane {
    private double payload;

    public CargoAirplane(String manufacturer, String model, double range, double fuelCapacity, double payload) {
        super(manufacturer, model, range, fuelCapacity);
        this.payload = payload;
    }

    public double getPayload() {
        return payload;
    }

    public void setPayload(double payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return super.toString() + " Payload: " + payload + "t";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof CargoAirplane)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        CargoAirplane that = (CargoAirplane) o;
        return Double.compare(that.getPayload(), getPayload()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPayload());
    }
}
