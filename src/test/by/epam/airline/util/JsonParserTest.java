package test.by.epam.airline.util;

import by.epam.airline.entity.Airplane;
import by.epam.airline.exception.JsonParserException;
import by.epam.airline.util.JsonParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class JsonParserTest {
    public static final String INCORRECT_FILE_NAME = "airline_wrong.json";
    public static final String EMPTY_FILE_NAME = "empty.json";

    @Test (expected = JsonParserException.class)
    public void noFileTest() throws JsonParserException {
        JsonParser parser = new JsonParser("123.json");
    }

    @Test (expected = JsonParserException.class)
    public void emptyFileTest() throws JsonParserException {
        JsonParser parser = new JsonParser(EMPTY_FILE_NAME);
    }

    @Test
    public void wrongDataTest() {
        try {
            JsonParser parser = new JsonParser(INCORRECT_FILE_NAME);
            String name = parser.readAirlineName();
            Assert.assertNull(name);
            List<Airplane> airplanes = parser.readAirplanes();
            Assert.assertTrue(airplanes.isEmpty());
        } catch (JsonParserException e) {
            Assert.fail("Exception must not be thrown");
        }
    }
}
