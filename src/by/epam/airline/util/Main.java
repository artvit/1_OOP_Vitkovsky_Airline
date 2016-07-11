package by.epam.airline.util;

import by.epam.airline.entity.Airline;
import by.epam.airline.exception.JsonParserException;
import by.epam.airline.creator.AirlineBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String OUTPUT_FILE_NAME = "result.txt";
    public static final String INPUT_FILE_NAME = "airline.json";

    public static void main(String[] args) {
        JsonParser parser = null;
        try {
            parser = new JsonParser(INPUT_FILE_NAME);
        } catch (JsonParserException e) {
            LOGGER.fatal("Can't create JsonParser", e);
            return;
        }
        LOGGER.info("Parser has been created");
        AirlineBuilder builder = new AirlineBuilder(parser);
        LOGGER.info("Airline builder has been created");
        Airline airline = builder.buildAirline();
        LOGGER.info("Airline has been built");
        TxtReporter reporter = new TxtReporter(airline, OUTPUT_FILE_NAME);
        LOGGER.info("TxtReporter builder has been created");
        reporter.report();
        LOGGER.info("Result reported");
    }
}
