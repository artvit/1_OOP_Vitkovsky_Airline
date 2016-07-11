package by.epam.airline.action;

public class AirplaneIdGenerator {
    private static long nextId = 0;

    private AirplaneIdGenerator() {}

    public static long getNextId() {
        return nextId++;
    }
}
