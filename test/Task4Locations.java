import org.junit.jupiter.api.Test;
import scale.AbstractTemperatureScale;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ET
 * @version 05/09/2019 15:35
 */
public class Task4Locations {
    /*
    Given I have region Birmingham ("BirminghamUK", "Birmingham in the UK")
    When I add a location ("UK", "United Kingdom") to Birmingham
    Then I expect Birmingham to have the location as a child
    And I expect the location to have Birmingham as parent
     */
    @Test
    public void createAValidLocationAttachedToARegion() {
        Region birmingham = Region.create("Birmingham", "Birmingham UK").getObject();
        Location aston = Location.create("AstonUni", "Aston University", 51, 0, 0.1, 'N', 1, 0,
                3.9, 'W', AbstractTemperatureScale.Celsius, birmingham).getObject();
        assertTrue(aston.getParent().isPresent());
        assertSame(birmingham, aston.getParent().get());
        assertSame(aston, birmingham.getChild("AstonUni").get());
    }

    /*
    When I try to create a location without a region
    Then I expect the location not to be created
    And to receive a message that no region was provided
     */
    @Test
    public void failToCreateWithNoParentRegion() {
        Validation<Location> aston = Location.create("AstonUni", "Aston University", 51, 0, 0.1,
                'N', 1, 0, 3.9, 'W', AbstractTemperatureScale.Celsius, null);
        assertFalse(aston.isPresent());
        assertTrue(aston.isEmpty());
        assertFalse(aston.noMessages());
        assertEquals("No region is provided", aston.getErrorMessage());
    }
}
