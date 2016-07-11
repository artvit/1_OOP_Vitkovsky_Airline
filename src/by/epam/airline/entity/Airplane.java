package by.epam.airline.entity;

import by.epam.airline.action.AirplaneIdGenerator;

import java.util.Objects;

public abstract class Airplane {
    private long id;
    private String manufacturer;
    private String model;
    private double range;
    private double fuelCapacity;

    public Airplane(String manufacturer, String model, double range, double fuelCapacity) {
        this.id = AirplaneIdGenerator.getNextId();
        this.manufacturer = manufacturer;
        this.model = model;
        this.range = range;
        this.fuelCapacity = fuelCapacity;
    }

    public long getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getFuelConsumption() {
        return fuelCapacity / range;
    }

    @Override
    public String toString() {
        return "Airplane:" +
                " id: " + id + " " + manufacturer + " " + model +
                " Range: " + range + "km" +
                " Fuel Capacity: " + fuelCapacity + "t" ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Airplane)) {
            return false;
        }
        Airplane airplane = (Airplane) o;
        return Long.compare(airplane.getId(), getId()) == 0 &&
                Double.compare(airplane.getRange(), getRange()) == 0 &&
                Double.compare(airplane.getFuelCapacity(), getFuelCapacity()) == 0 &&
                Objects.equals(getManufacturer(), airplane.getManufacturer()) &&
                Objects.equals(getModel(), airplane.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getManufacturer(), getModel(), getRange(), getFuelCapacity());
    }
}
