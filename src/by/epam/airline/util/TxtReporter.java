package by.epam.airline.util;

import by.epam.airline.entity.Airline;
import by.epam.airline.action.CargoCounter;
import by.epam.airline.action.PassengerCounter;
import by.epam.airline.action.AirplaneFinder;
import by.epam.airline.action.AirlineSorter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TxtReporter {
    private static final Logger LOGGER = LogManager.getLogger();

    private Airline airline;
    private String filename;

    public TxtReporter(Airline airline, String filename) {
        this.airline = airline;
        this.filename = filename;
    }

    public void report() {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Paths.get(filename)))) {
            writer.println("Total capacity: " + PassengerCounter.countTotalCapacity(airline));
            LOGGER.info("Total capacity counted successfully");
            writer.println("Total payload: " + CargoCounter.countTotalPayload(airline));
            LOGGER.info("Total payload counted successfully");
            writer.println("Airline before sorting:");
            writer.println(airline);
            AirlineSorter.sortByRange(airline);
            writer.println("Sorted airline:");
            writer.println(airline);
            LOGGER.info("Sorting has been successfully performed");
            writer.println("Result for searching airplanes with fuel consumption between 0 and 1 t/km");
            AirplaneFinder finder = new AirplaneFinder(airline);
            writer.println(finder.findByFuelConsumption(0.0, 1.0));
            LOGGER.info("Searching successful");
            LOGGER.info("Report successfully created");
        } catch (IOException e) {
            LOGGER.fatal("Fatal error while reporting: " + e.getMessage(), e);
        }
    }
}
