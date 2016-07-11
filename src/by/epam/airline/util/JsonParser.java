package by.epam.airline.util;

import by.epam.airline.entity.Airplane;
import by.epam.airline.entity.CargoAirplane;
import by.epam.airline.entity.PassengerAirplane;
import by.epam.airline.exception.JsonParserException;
import by.epam.airline.exception.WrongArgumentException;
import by.epam.airline.creator.AirplaneFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.json.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String AIRLINE_NAME = "name";
    public static final String AIRLINE_AIRPLANES = "airplanes";
    public static final String AIRPLANE_TYPE = "type";
    public static final String AIRPLANE_MANUFACTURER = "manufacturer";
    public static final String AIRPLANE_MODEL = "model";
    public static final String AIRPLANE_RANGE = "range";
    public static final String AIRPLANE_FUEL_CAPACITY = "fuel_capacity";
    public static final String AIRPLANE_PAYLOAD = "payload";
    public static final String AIRPLANE_CAPACITY = "capacity";

    public static final String CARGO_TYPE = "cargo";
    public static final String PASSEBGER_TYPE = "passenger";

    private JsonObject jsonAirlineObject;
    private AirplaneFactory airplaneFactory;

    public JsonParser(String filename) throws JsonParserException {
        airplaneFactory = new AirplaneFactory();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(filename))){
            JsonReader reader = Json.createReader(bufferedReader);
            this.jsonAirlineObject = reader.readObject();
        } catch (IOException e) {
            throw new JsonParserException("Can't create JsonParser", e);
        } catch (JsonException e) {
            throw new JsonParserException("Can't create JsonParser due to reading error", e);
        }
    }

    public String readAirlineName() {
        try {
            String name = jsonAirlineObject.getString(AIRLINE_NAME);
            LOGGER.info("Airline name extracted");
            return name;
        } catch (Exception e) {
            LOGGER.error("Can't extract airline name");
            return null;
        }
    }

    public List<Airplane> readAirplanes() {
        List<Airplane> airplaneList = new ArrayList<>();
        JsonArray array = jsonAirlineObject.getJsonArray(AIRLINE_AIRPLANES);
        for (JsonObject jsonObject : array.getValuesAs(JsonObject.class)) {
            String type = jsonObject.getString(AIRPLANE_TYPE);
            Airplane airplane = null;
            if (CARGO_TYPE.equals(type)) {
                airplane = parseCargoAirplane(jsonObject);
            } else if (PASSEBGER_TYPE.equals(type)) {
                airplane = parsePassengerAirplane(jsonObject);
            }
            if (airplane != null) {
                airplaneList.add(airplane);
                LOGGER.info("New airplane has been added");
            }
        }
        LOGGER.info("List of airplanes created");
        return airplaneList;
    }

    private CargoAirplane parseCargoAirplane(JsonObject jsonObject) {
        try {
            String manufacturer = jsonObject.getString(AIRPLANE_MANUFACTURER);
            String model = jsonObject.getString(AIRPLANE_MODEL);
            double range = jsonObject.getJsonNumber(AIRPLANE_RANGE).doubleValue();
            double fuelCapacity = jsonObject.getJsonNumber(AIRPLANE_FUEL_CAPACITY).doubleValue();
            double payload = jsonObject.getJsonNumber(AIRPLANE_PAYLOAD).doubleValue();
            try {
                return airplaneFactory.createCargoAirplane(manufacturer, model, range, fuelCapacity, payload);
            } catch (WrongArgumentException e) {
                LOGGER.error("Can't create airplane " + manufacturer + " " + model, e);
                return null;
            }
        } catch (Exception e) {
            LOGGER.error("Can't parse cargo airplane");
            return null;
        }
    }

    private PassengerAirplane parsePassengerAirplane(JsonObject jsonObject) {
        try {
            String manufacturer = jsonObject.getString(AIRPLANE_MANUFACTURER);
            String model = jsonObject.getString(AIRPLANE_MODEL);
            double range = jsonObject.getJsonNumber(AIRPLANE_RANGE).doubleValue();
            double fuelCapacity = jsonObject.getJsonNumber(AIRPLANE_FUEL_CAPACITY).doubleValue();
            int capacity = jsonObject.getJsonNumber(AIRPLANE_CAPACITY).intValue();
            try {
                return airplaneFactory.createPassengerAirplane(manufacturer, model, range, fuelCapacity, capacity);
            } catch (WrongArgumentException e) {
                LOGGER.error("Can't create airplane " + manufacturer + " " + model, e);
                return null;
            }
        } catch (Exception e) {
            LOGGER.error("Can't parse passenger airplane");
            return null;
        }
    }
}
