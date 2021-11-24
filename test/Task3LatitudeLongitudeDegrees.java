import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ET
 * @version 02/09/2019 13:12
 */
public class Task3LatitudeLongitudeDegrees {
    /*
     * Given the latitude value of 51.477817
     * When I create a Latitude object
     * Then I expect it to be created
     * And the integer degrees to be 51
     * And the minutes to be 28
     * And the seconds to be 40.1412
     * And the direction to be North
     * And the double degrees to be 51.477817
     */
    @Test
    public void verifyLatitude() {
        Validation<Latitude> validLatitude = Latitude.create(51.477817);
        assertTrue(validLatitude.isPresent());
        Latitude latitude = validLatitude.getObject();
        assertEquals(51, latitude.getDegrees());
        assertEquals(28, latitude.getMinutes());
        assertEquals(40.1412,latitude.getSeconds(), 0.0001);
        assertEquals('N', latitude.getDirection());
        assertEquals(51.477817, latitude.getDMSDegree(), 0.0);
    }

    @Test
    public void verifyDegreesInvalidLatitude() {
        /*
        Given a degree value of -90.6
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying the degrees are out of range
         */
        Validation<Latitude> validLatitude = Latitude.create(-90.6);
        assertFalse(validLatitude.isPresent());
        assertTrue(validLatitude.isEmpty());
        assertFalse(validLatitude.noMessages());
        assertEquals("Latitude degree value out of range should be between -90 and 90",
                validLatitude.getErrorMessage());

        /*
        Given a degree value of -90
        When I create a latitude object
        Then I expect the object to be created
        And there to be no error message
         */
        validLatitude = Latitude.create(-90);
        assertTrue(validLatitude.isPresent());
        assertFalse(validLatitude.isEmpty());
        assertTrue(validLatitude.noMessages());

        /*
        Given a degree value of 90.06
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying the degrees are out of range
         */
        validLatitude = Latitude.create(90.06);
        assertFalse(validLatitude.isPresent());
        assertTrue(validLatitude.isEmpty());
        assertFalse(validLatitude.noMessages());
        assertEquals("Latitude degree value out of range should be between -90 and 90",
                validLatitude.getErrorMessage());
    }

    /**
     * Given the longitude value of 51.477817
     * When I create a Longitude object
     * Then I expect it to be created
     * And the integer degrees to be 51
     * And the minutes to be 28
     * And the seconds to be 40.1412
     * And the direction to be East
     * And the double degrees to be 51.477817
     */
    @Test
    public void verifyLongitude() {
        Validation<Longitude> validLongitude = Longitude.create(51.477817);
        assertTrue(validLongitude.isPresent());
        Longitude longitude = validLongitude.getObject();
        assertEquals(51, longitude.getDegrees());
        assertEquals(28, longitude.getMinutes());
        assertEquals(40.1412,longitude.getSeconds(), 0.0001);
        assertEquals('E', longitude.getDirection());
        assertEquals(51.477817, longitude.getDMSDegree(), 0.0);
    }

    @Test
    public void verifyDegreesInvalidLongitude() {
        /*
        Given a degree value of 180
        When I create a latitude object
        Then I expect the object to be created
        And there to be no error message
         */
        Validation<Longitude> longitudeValid = Longitude.create(180.0);
        assertTrue(longitudeValid.isPresent());
        assertFalse(longitudeValid.isEmpty());
        assertTrue(longitudeValid.noMessages());

        /*
        Given a degree value of -180.01
        When I create a longitude object
        Then I expect the object not to be created
        And there to be an error message saying the degrees are out of range
         */
        longitudeValid = Longitude.create(-180.01);
        assertFalse(longitudeValid.isPresent());
        assertTrue(longitudeValid.isEmpty());
        assertFalse(longitudeValid.noMessages());
        assertEquals("Longitude degree value out of range should be between -180 and 180",
                longitudeValid.getErrorMessage());

        /*
        Given a degree value of 180.01
        When I create a longitude object
        Then I expect the object not to be created
        And there to be an error message saying the degrees are out of range
         */
        longitudeValid = Longitude.create(180.01);
        assertFalse(longitudeValid.isPresent());
        assertTrue(longitudeValid.isEmpty());
        assertFalse(longitudeValid.noMessages());
        assertEquals("Longitude degree value out of range should be between -180 and 180",
                longitudeValid.getErrorMessage());
    }
}
