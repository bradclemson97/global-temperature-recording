import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ET
 * @version 29/08/2019 14:29
 */
public class Task3LatitudeLongitudeDegreesMinutesSecondsDirection {
    /**
     * Given a coordinate for Greenwich of 51, 28, 40.1412, 'N'
     * When I have created a Latitude object
     * Then the degrees should be 51
     * And the minutes should be 28
     * And the seconds should be 40.1412
     * And the direction should be North
     * And the double degrees value should be 51.477817
     */
    @Test
    public void verifyLatitude() {
        Validation<Latitude> validLatitude = Latitude.create(51, 28, 40.1412, 'N');
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
        Given a degree value of -1, 1, 1.1 S
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying the degrees are out of range
         */
        Validation<Latitude> validLatitude = Latitude.create(-1, 1, 1.1, 'S');
        assertFalse(validLatitude.isPresent());
        assertTrue(validLatitude.isEmpty());
        assertFalse(validLatitude.noMessages());
        assertEquals("Latitude degree value out of range should be between 0 and 90",
                validLatitude.getErrorMessage());

        /*
        Given a degree value of 0, 1, 1.1 S
        When I create a latitude object
        Then I expect the object to be created
        And there to be no error message
         */
        validLatitude = Latitude.create(0, 1,1.1,'S');
        assertTrue(validLatitude.isPresent());
        assertFalse(validLatitude.isEmpty());
        assertTrue(validLatitude.noMessages());

        /*
        Given a degree value of 91, 1, 1.1 S
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying the degrees are out of range
         */
        validLatitude = Latitude.create(91, 1,1.1,'S');
        assertFalse(validLatitude.isPresent());
        assertTrue(validLatitude.isEmpty());
        assertFalse(validLatitude.noMessages());
        assertEquals("Latitude degree value out of range should be between 0 and 90",
                validLatitude.getErrorMessage());

        /*
        Given a degree value of 90, 0, 0.1 S
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying the degrees are out of range
         */
        validLatitude = Latitude.create(90, 0,0.1,'S');
        assertFalse(validLatitude.isPresent());
        assertTrue(validLatitude.isEmpty());
        assertFalse(validLatitude.noMessages());
        assertEquals("Latitude degree value out of range should be between 0 and 90",
                validLatitude.getErrorMessage());

        /*
        Given a degree value of 90, 1, 0.0 S
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying the degrees are out of range
         */
        validLatitude = Latitude.create(90, 1,0.0,'S');
        assertFalse(validLatitude.isPresent());
        assertTrue(validLatitude.isEmpty());
        assertFalse(validLatitude.noMessages());
        assertEquals("Latitude degree value out of range should be between 0 and 90",
                validLatitude.getErrorMessage());
    }

    @Test
    public void verifyDirectionInvalidLatitude() {
        /*
        Given a degree value of 0, 1, 1.1 X
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying the direction is invalid
         */
        Validation<Latitude> validLatitude = Latitude.create(0, 1,1.1,'X');
        assertFalse(validLatitude.isPresent());
        assertTrue(validLatitude.isEmpty());
        assertFalse(validLatitude.noMessages());
        assertEquals("Latitude direction should be 'S' or 'N'",
                validLatitude.getErrorMessage());

        /*
        Given a degree value of 0, -1, 1.1 N
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying the minutes are out of range
         */
        validLatitude = Latitude.create(0, -1,1.1,'N');
        assertFalse(validLatitude.isPresent());
        assertTrue(validLatitude.isEmpty());
        assertFalse(validLatitude.noMessages());
        assertEquals("Latitude minutes out of range should be between 0 and 60 inclusive",
                validLatitude.getErrorMessage());

        /*
        Given a degree value of 0, 61, 1.1 N
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying the minutes are out of range
         */
        validLatitude = Latitude.create(0, 61,1.1,'N');
        assertFalse(validLatitude.isPresent());
        assertTrue(validLatitude.isEmpty());
        assertFalse(validLatitude.noMessages());
        assertEquals("Latitude minutes out of range should be between 0 and 60 inclusive",
                validLatitude.getErrorMessage());

        /*
        Given a degree value of 0, 60, 0.1 N
        When I create a latitude object
        Then I expect the object not to be created
        And there to be an error message saying the minutes are out of range
         */
        validLatitude = Latitude.create(0, 60,0.1,'N');
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
        And there to be an error message saying the seconds are out of range
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
        And there to be an error message saying the seconds are out of range
         */
        validLatitude = Latitude.create(0, 1,60.0001,'S');
        assertFalse(validLatitude.isPresent());
        assertTrue(validLatitude.isEmpty());
        assertFalse(validLatitude.noMessages());
        assertEquals("Latitude seconds out of range should be between 0 and 60 inclusive",
                validLatitude.getErrorMessage());
    }

    /**
     * Given the longitude value of 51, 28, 40.1412, E
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
        Validation<Longitude> validLongitude = Longitude.create(51, 28, 40.1412, 'E');
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
        Given a degree value of -1, 1, 1.1 E
        When I create a longitude object
        Then I expect the object not to be created
        And there to be an error message saying the degrees are out of range
         */
        Validation<Longitude> longitudeValid = Longitude.create(-1, 1, 1.1, 'E');
        assertFalse(longitudeValid.isPresent());
        assertTrue(longitudeValid.isEmpty());
        assertFalse(longitudeValid.noMessages());
        assertEquals("Longitude degree value out of range should be between 0 and 180",
                longitudeValid.getErrorMessage());

        /*
        Given a degree value of 0, 1, 1.1 E
        When I create a longitude object
        Then I expect the object to be created
        And there to be no error message
         */
        longitudeValid = Longitude.create(0, 1,1.1,'E');
        assertTrue(longitudeValid.isPresent());
        assertFalse(longitudeValid.isEmpty());
        assertTrue(longitudeValid.noMessages());

        /*
        Given a degree value of 181, 1, 1.1 E
        When I create a longitude object
        Then I expect the object not to be created
        And there to be an error message saying the degrees are out of range
         */
        longitudeValid = Longitude.create(181, 1,1.1,'E');
        assertFalse(longitudeValid.isPresent());
        assertTrue(longitudeValid.isEmpty());
        assertFalse(longitudeValid.noMessages());
        assertEquals("Longitude degree value out of range should be between 0 and 180",
                longitudeValid.getErrorMessage());

        /*
        Given a degree value of 180, 0, 0.1 E
        When I create a longitude object
        Then I expect the object not to be created
        And there to be an error message saying the degrees are out of range
         */
        longitudeValid = Longitude.create(180, 0,0.1,'E');
        assertFalse(longitudeValid.isPresent());
        assertTrue(longitudeValid.isEmpty());
        assertFalse(longitudeValid.noMessages());
        assertEquals("Longitude degree value out of range should be between 0 and 180",
                longitudeValid.getErrorMessage());

        /*
        Given a degree value of 180, 1, 0.0 E
        When I create a longitude object
        Then I expect the object not to be created
        And there to be an error message saying the degrees are out of range
         */
        longitudeValid = Longitude.create(180, 1,0.0,'E');
        assertFalse(longitudeValid.isPresent());
        assertTrue(longitudeValid.isEmpty());
        assertFalse(longitudeValid.noMessages());
        assertEquals("Longitude degree value out of range should be between 0 and 180",
                longitudeValid.getErrorMessage());
    }

    @Test
    public void verifyMinutesInvalidLongitude() {
        /*
        Given a degree value of 0, 1, 1.1 X
        When I create a longitude object
        Then I expect the object not to be created
        And there to be an error message saying the direction is invalid
         */
        Validation<Longitude> longitudeValid = Longitude.create(0, 1,1.1,'X');
        assertFalse(longitudeValid.isPresent());
        assertTrue(longitudeValid.isEmpty());
        assertFalse(longitudeValid.noMessages());
        assertEquals("Longitude direction should be 'E' or 'W'",
                longitudeValid.getErrorMessage());

        /*
        Given a degree value of 0, -1, 1.1 W
        When I create a longitude object
        Then I expect the object not to be created
        And there to be an error message saying the minutes are out of range
         */
        longitudeValid = Longitude.create(0, -1,1.1,'W');
        assertFalse(longitudeValid.isPresent());
        assertTrue(longitudeValid.isEmpty());
        assertFalse(longitudeValid.noMessages());
        assertEquals("Longitude minutes out of range should be between 0 and 60 inclusive",
                longitudeValid.getErrorMessage());

        /*
        Given a degree value of 0, 61, 1.1 W
        When I create a longitude object
        Then I expect the object not to be created
        And there to be an error message saying the minutes are out of range
         */
        longitudeValid = Longitude.create(0, 61,1.1,'W');
        assertFalse(longitudeValid.isPresent());
        assertTrue(longitudeValid.isEmpty());
        assertFalse(longitudeValid.noMessages());
        assertEquals("Longitude minutes out of range should be between 0 and 60 inclusive",
                longitudeValid.getErrorMessage());

        /*
        Given a degree value of 0, 60, 0.1 W
        When I create a longitude object
        Then I expect the object not to be created
        And there to be an error message saying the minutes are out of range
         */
        longitudeValid = Longitude.create(0, 60,0.1,'W');
        assertFalse(longitudeValid.isPresent());
        assertTrue(longitudeValid.isEmpty());
        assertFalse(longitudeValid.noMessages());
        assertEquals("Longitude minutes out of range should be between 0 and 60 inclusive",
                longitudeValid.getErrorMessage());
    }

    @Test
    public void verifySecondsInvalidLongitude() {
        /*
        Given a degree value of 0, 60, 0.0 W
        When I create a longitude object
        Then I expect the object to be created
        And there to be no error message
         */
        Validation<Longitude> longitudeValid = Longitude.create(0, 60,0.0,'W');
        assertTrue(longitudeValid.isPresent());
        assertFalse(longitudeValid.isEmpty());
        assertTrue(longitudeValid.noMessages());

        /*
        Given a degree value of 0, 1, -0.0001 E
        When I create a longitude object
        Then I expect the object not to be created
        And there to be an error message saying the seconds are out of range
         */
        longitudeValid = Longitude.create(0, 1,-0.0001,'E');
        assertFalse(longitudeValid.isPresent());
        assertTrue(longitudeValid.isEmpty());
        assertFalse(longitudeValid.noMessages());
        assertEquals("Longitude seconds out of range should be between 0 and 60 inclusive",
                longitudeValid.getErrorMessage());

        /*
        Given a degree value of 0, 1, 60.0001 E
        When I create a longitude object
        Then I expect the object not to be created
        And there to be an error message saying the seconds are out of range
         */
        longitudeValid = Longitude.create(0, 1,60.0001,'E');
        assertFalse(longitudeValid.isPresent());
        assertTrue(longitudeValid.isEmpty());
        assertFalse(longitudeValid.noMessages());
        assertEquals("Longitude seconds out of range should be between 0 and 60 inclusive",
                longitudeValid.getErrorMessage());
    }
}
