package by.epam.airline.creator;

import by.epam.airline.entity.Airplane;
import by.epam.airline.entity.Airline;
import by.epam.airline.util.JsonParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AirlineBuilder {
    private static final Logger LOGGER = LogManager.getLogger();

    private JsonParser parser;

    public AirlineBuilder(JsonParser parser) {
        this.parser = parser;
    }

    public Airline buildAirline() {
        String airlineName = parser.readAirlineName();
        Airline airline;
        if (airlineName != null) {
            airline = new Airline(airlineName);
            LOGGER.info("Empty named airline created");
        } else {
            airline = new Airline();
            LOGGER.info("Empty unnamed airline created");
        }
        List<Airplane> airplanes = parser.readAirplanes();
        airline.setAirplanes(airplanes);
        LOGGER.info("Airplanes has been added to airline");
        return airline;
    }
}
