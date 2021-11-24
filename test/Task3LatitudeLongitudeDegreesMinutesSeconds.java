import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author ET
 * @version 02/09/2019 11:22
 */
public class Task3LatitudeLongitudeDegreesMinutesSeconds {
    /**
     * Given a coordinate for Greenwich of 51, 28, 40.1412
     * When I have created a Latitude object
     * Then the degrees should be 51
     * And the minutes should be 28
     * And the seconds should be 40.1412
     * And the direction should be North
     * And the double degrees value should be 51.477817
     */
    @Test
    public void verifyLatitude() {
        Validation<Latitude> validLatitude = Latitude.create(51, 28, 40.1412);
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
        Given a degree value of -91, 1, 1.1
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying the degrees are out of range
         */
        Validation<Latitude> validLatitude = Latitude.create(-91, 1, 1.1);
        assertFalse(validLatitude.isPresent());
        assertTrue(validLatitude.isEmpty());
        assertFalse(validLatitude.noMessages());
        assertEquals("Latitude degree value out of range should be between -90 and 90",
                validLatitude.getErrorMessage());

        /*
        Given a degree value of -1, 1, 1.1
        When I create a latitude object
        Then I expect the object to be created
        And there to be no error message
         */
        validLatitude = Latitude.create(-1, 1,1.1);
        assertTrue(validLatitude.isPresent());
        assertFalse(validLatitude.isEmpty());
        assertTrue(validLatitude.noMessages());

        /*
        Given a degree value of -90, 0, 0.1
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying the degrees are out of range
         */
        validLatitude = Latitude.create(-90, 0,0.1);
        assertFalse(validLatitude.isPresent());
        assertTrue(validLatitude.isEmpty());
        assertFalse(validLatitude.noMessages());
        assertEquals("Latitude degree value out of range should be between -90 and 90",
                validLatitude.getErrorMessage());

        /*
        Given a degree value of -90, 1, 0.0
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying the degrees are out of range
         */
        validLatitude = Latitude.create(-90, 1,0.0);
        assertFalse(validLatitude.isPresent());
        assertTrue(validLatitude.isEmpty());
        assertFalse(validLatitude.noMessages());
        assertEquals("Latitude degree value out of range should be between -90 and 90",
                validLatitude.getErrorMessage());
    }

    @Test
    public void verifyDirectionInvalidLatitude() {
        /*
        Given a degree value of 0, -1, 1.1
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying minutes are out of range
         */
        Validation<Latitude> validLatitude = Latitude.create(0, -1,1.1);
        assertFalse(validLatitude.isPresent());
        assertTrue(validLatitude.isEmpty());
        assertFalse(validLatitude.noMessages());
        assertEquals("Latitude minutes out of range should be between 0 and 60 inclusive",
                validLatitude.getErrorMessage());

        /*
        Given a degree value of 0, 61, 1.1
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying minutes are out of range
         */
        validLatitude = Latitude.create(0, 61,1.1);
        assertFalse(validLatitude.isPresent());
        assertTrue(validLatitude.isEmpty());
        assertFalse(validLatitude.noMessages());
        assertEquals("Latitude minutes out of range should be between 0 and 60 inclusive",
                validLatitude.getErrorMessage());

        /*
        Given a degree value of 0, 60, 0.1
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying minutes are out of range
         */
        validLatitude = Latitude.create(0, 60,0.1);
        assertFalse(validLatitude.isPresent());
        assertTrue(validLatitude.isEmpty());
        assertFalse(validLatitude.noMessages());
        assertEquals("Latitude minutes out of range should be between 0 and 60 inclusive",
                validLatitude.getErrorMessage());
    }

    @Test
    public void verifySecondsInvalidLatitude() {
        /*
        Given a degree value of 0, 60, 0.0 N
        When I create a latitude object
        Then I expect the object to be created
        And there to be no error message
         */
        Validation<Latitude> validLatitude = Latitude.create(0, 60,0.0,'N');
        assertTrue(validLatitude.isPresent());
        assertFalse(validLatitude.isEmpty());
        assertTrue(validLatitude.noMessages());

        /*
        Given a degree value of 0, 1, -0.0001 S
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying seconds are out of range
         */
        validLatitude = Latitude.create(0, 1,-0.0001,'S');
        assertFalse(validLatitude.isPresent());
        assertTrue(validLatitude.isEmpty());
        assertFalse(validLatitude.noMessages());
        assertEquals("Latitude seconds out of range should be between 0 and 60 inclusive",
                validLatitude.getErrorMessage());

        /*
        Given a degree value of 0, 1, 60.0001 S
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying seconds are out of range
         */
        validLatitude = Latitude.create(0, 1,60.0001,'S');
        assertFalse(validLatitude.isPresent());
        assertTrue(validLatitude.isEmpty());
        assertFalse(validLatitude.noMessages());
        assertEquals("Latitude seconds out of range should be between 0 and 60 inclusive",
                validLatitude.getErrorMessage());
    }

    /**
     * Given the longitude value of 51, 28, 40.1412
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
        Validation<Longitude> validLongitude = Longitude.create(51, 28, 40.1412);
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
        Given a degree value of 0, 1, 1.1
        When I create a latitude object
        Then I expect the object to be created
        And there to be no error message
         */
        Validation<Longitude> longitudeValid = Longitude.create(0, 1,1.1);
        assertTrue(longitudeValid.isPresent());
        assertFalse(longitudeValid.isEmpty());
        assertTrue(longitudeValid.noMessages());

        /*
        Given a degree value of -181, 1, 1.1
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying the degrees are out of range
         */
        longitudeValid = Longitude.create(-181, 1,1.1);
        assertFalse(longitudeValid.isPresent());
        assertTrue(longitudeValid.isEmpty());
        assertFalse(longitudeValid.noMessages());
        assertEquals("Longitude degree value out of range should be between -180 and 180",
                longitudeValid.getErrorMessage());

        /*
        Given a degree value of -180, 0, 0.1
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying the degrees are out of range
         */
        longitudeValid = Longitude.create(-180, 0,0.1);
        assertFalse(longitudeValid.isPresent());
        assertTrue(longitudeValid.isEmpty());
        assertFalse(longitudeValid.noMessages());
        assertEquals("Longitude degree value out of range should be between -180 and 180",
                longitudeValid.getErrorMessage());

        /*
        Given a degree value of 180, 1, 0.0
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying the degrees are out of range
         */
        longitudeValid = Longitude.create(180, 1,0.0);
        assertFalse(longitudeValid.isPresent());
        assertTrue(longitudeValid.isEmpty());
        assertFalse(longitudeValid.noMessages());
        assertEquals("Longitude degree value out of range should be between -180 and 180",
                longitudeValid.getErrorMessage());
    }

    @Test
    public void verifyMinutesInvalidLongitude() {
        /*
        Given a degree value of 0, 01, 1.1
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying the minutes are out of range
         */
        Validation<Longitude> longitudeValid = Longitude.create(0, -1,1.1);
        assertFalse(longitudeValid.isPresent());
        assertTrue(longitudeValid.isEmpty());
        assertFalse(longitudeValid.noMessages());
        assertEquals("Longitude minutes out of range should be between 0 and 60 inclusive",
                longitudeValid.getErrorMessage());

        /*
        Given a degree value of 0, 61, 1.1
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying the minutes are out of range
         */
        longitudeValid = Longitude.create(0, 61,1.1);
        assertFalse(longitudeValid.isPresent());
        assertTrue(longitudeValid.isEmpty());
        assertFalse(longitudeValid.noMessages());
        assertEquals("Longitude minutes out of range should be between 0 and 60 inclusive",
                longitudeValid.getErrorMessage());

        /*
        Given a degree value of 0, 60, 0.1
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying the minutes are out of range
         */
        longitudeValid = Longitude.create(0, 60,0.1);
        assertFalse(longitudeValid.isPresent());
        assertTrue(longitudeValid.isEmpty());
        assertFalse(longitudeValid.noMessages());
        assertEquals("Longitude minutes out of range should be between 0 and 60 inclusive",
                longitudeValid.getErrorMessage());
    }

    @Test
    public void verifySecondsInvalidLongitude() {
        /*
        Given a degree value of 0, 60, 0.0
        When I create a latitude object
        Then I expect the object to be created
        And there to be no error message
         */
        Validation<Longitude> longitudeValid = Longitude.create(0, 60,0.0);
        assertTrue(longitudeValid.isPresent());
        assertFalse(longitudeValid.isEmpty());
        assertTrue(longitudeValid.noMessages());

        /*
        Given a degree value of 0, 1, -0.0001
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying the seconds are out of range
         */
        longitudeValid = Longitude.create(0, 1,-0.0001);
        assertFalse(longitudeValid.isPresent());
        assertTrue(longitudeValid.isEmpty());
        assertFalse(longitudeValid.noMessages());
        assertEquals("Longitude seconds out of range should be between 0 and 60 inclusive",
                longitudeValid.getErrorMessage());

        /*
        Given a degree value of 0, 1, 60.0001
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying the seconds are out of range
         */
        longitudeValid = Longitude.create(0, 1,60.0001);
        assertFalse(longitudeValid.isPresent());
        assertTrue(longitudeValid.isEmpty());
        assertFalse(longitudeValid.noMessages());
        assertEquals("Longitude seconds out of range should be between 0 and 60 inclusive",
                longitudeValid.getErrorMessage());
    }
}
