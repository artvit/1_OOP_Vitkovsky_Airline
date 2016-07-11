package by.epam.airline.entity;

import by.epam.airline.entity.Airplane;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Airline {
    private List<Airplane> airplanes;
    private String name;

    public Airline() {
        this.airplanes = new ArrayList<>();
        this.name = "No name Airline";
    }

    public Airline(String name) {
        this.airplanes = new ArrayList<>();
        this.name = name;
    }

    public Airline(Collection<Airplane> airplanes, String name) {
        this.airplanes = new ArrayList<>(airplanes);
        this.name = name;
    }

    public List<Airplane> getAirplanes() {
        List<Airplane> result = new ArrayList<>(airplanes);
        return result;
    }

    public void setAirplanes(List<Airplane> airplanes) {
        this.airplanes = airplanes;
    }

    public void addAirplane(Airplane airplane) {
        airplanes.add(airplane);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String result = "Airline " + name;
        for (Airplane airplane : airplanes) {
            result += "\n" + airplane;
        }
        return result;
    }
}
