import org.junit.jupiter.api.Test;
import scale.CelsiusScale;
import scale.TemperatureScale;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ET
 * @version 30/08/2019 14:39
 */
public class Task3Location {
    Region region = Region.create("Anywhere", "Anywhere").getObject();
    /*
    When I create a location with valid fields
    Then I expect it to be created
    And no error messages returned
    And the location name to match that which I used
    And the description to match that which I used
    And with the correct latitude
    And with the correct longitude
    And a default temperature scale
     */
    @Test
    public void locationCreation() {
        TemperatureScale temperatureScale = new CelsiusScale();
        Validation<Location> validLocation = Location.create("Location name", "Any thing goes",
                 51, 0, 0.0, 'N', 1, 30, 0.0,'E', temperatureScale, region);
         assertTrue(validLocation.isPresent());
         assertTrue(validLocation.noMessages());
        Location location = validLocation.getObject();
        assertEquals("Location name", location.getName());
        assertEquals("Any thing goes", location.getDescription());
        assertEquals(51.0, location.getLatitude().getDMSDegree(), 0.001);
        assertEquals(1.5, location.getLongitude().getDMSDegree(), 0.001);
        assertSame(temperatureScale, location.getTemperatureDefaultScale());
    }

    /*
    When I try to create a location with a null name and an empty location
    Then I expect no location to be created
    And I expect an error message that says no location name and description was provided
     */
    @Test
    public void noNameAndDescription() {
        Validation<Location> validLocation = Location.create(null, "",
                51, 0, 0.0, 'N', 1, 30, 0.0,'E', new CelsiusScale(), region);
        assertTrue(validLocation.isEmpty());
        assertFalse(validLocation.noMessages());
        assertEquals("No location name provided.\nNo location description provided.",
                validLocation.getErrorMessage());
    }

    /*
    When I try to create a location with an empty name and a null location
    Then I expect no location to be created
    And I expect an error message that says no location name and description was provided
     */
    @Test
    public void noNameAndDescription2() {
        Validation<Location> validLocation = Location.create("", null,
                51, 0, 0.0, 'N', 1, 30, 0.0,'E', new CelsiusScale(), region);
        assertTrue(validLocation.isEmpty());
        assertFalse(validLocation.noMessages());
        assertEquals("No location name provided.\nNo location description provided.",
                validLocation.getErrorMessage());
    }

    /*
    When I try to create a location with a null temperature scale
    Then I expect no location to be created
    And I expect an error message that says no temperature scale was selected
     */
    @Test
    public void noTemperatureScale() {
        Validation<Location> validLocation = Location.create("Location name", "Any thing goes",
                51, 0, 0.0, 'N', 1, 30, 0.0,'E', null, region);
        assertTrue(validLocation.isEmpty());
        assertFalse(validLocation.noMessages());
        assertEquals("No temperature scale selected", validLocation.getErrorMessage());
    }

    /*
    When I try to create an object with a latitude degrees out of range
    Then I expect no location to be created
    And I expect an error message that says the degrees are out of range
     */
    @Test
    public void invalidLatitude() {
        Validation<Location> validLocation = Location.create("Location name", "Any thing goes",
                200, 0, 0.0, 'N', 1, 30, 0.0,'E', new CelsiusScale(), region);
        assertTrue(validLocation.isEmpty());
        assertFalse(validLocation.noMessages());
        assertEquals("Latitude degree value out of range should be between 0 and 90", validLocation.getErrorMessage());

    }
}
