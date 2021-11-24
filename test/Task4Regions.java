import org.junit.jupiter.api.Test;
import scale.AbstractTemperatureScale;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ET
 * @version 03/09/2019 15:47
 */
public class Task4Regions {
    /*
    Given I have no regions or locations
    When I create a region "Europe" "Geographical Europe" with no parent region
    Then I expect the region to be created
    And there to be no error messages
    And the region's name to be "Europe"
    And the region's description to be "Geographical Europe"
    And the region to have no parent
    And the region to have no children
    */
    @Test
    public void verifyRegionCreation() {
        Validation<Region> regionValidation = Region.create("Europe", "Geographical Europe");
        assertTrue(regionValidation.isPresent());
        assertTrue(regionValidation.noMessages());
        Region region = regionValidation.getObject();
        assertEquals("Europe", region.getName());
        assertEquals("Geographical Europe", region.getDescription());
        assertFalse(region.getParent().isPresent());
        assertTrue(region.getChildren().isEmpty());
    }

    /*
    Given I try to create a region with no name
    Then I expect the region not to be created
    And to receive a message that no name was provided
     */
    @Test
    public void rejectNoName() {
        Validation<Region> regionValidation = Region.create("", "Geographical Europe");
        assertFalse(regionValidation.isPresent());
        assertFalse(regionValidation.noMessages());
        assertEquals("No region name provided.", regionValidation.getErrorMessage());

        regionValidation = Region.create(null, "Geographical Europe");
        assertFalse(regionValidation.isPresent());
        assertFalse(regionValidation.noMessages());
        assertEquals("No region name provided.", regionValidation.getErrorMessage());
    }

    /*
    Given I try to create a region with no description
    Then I expect the region not to be created
    And to receive a message that no description was provided
     */
    @Test
    public void rejectNoDescription() {
        Validation<Region> regionValidation = Region.create("Europe", "");
        assertFalse(regionValidation.isPresent());
        assertFalse(regionValidation.noMessages());
        assertEquals("No region description provided.", regionValidation.getErrorMessage());

        regionValidation = Region.create("Europe", null);
        assertFalse(regionValidation.isPresent());
        assertFalse(regionValidation.noMessages());
        assertEquals("No region description provided.", regionValidation.getErrorMessage());
    }

    /*
    Given I have region Europe ("Europe", "Geographical Europe")
    When I add a child region UK ("UK", "United Kingdom") to Europe
    Then I expect Europe to have UK as a child
    And I expect the UK to have Europe as parent
    */
    @Test
    public void verifyAddingOfParent() {
        Validation<Region> parentRegionValidation = Region.create("Europe", "Geographical Europe");
        Region parent = parentRegionValidation.getObject();
        Validation<Region> childRegionValidation = Region.create("UK", "United Kingdom",
                parent);
        Region child = childRegionValidation.getObject();
        assertTrue(child.getParent().isPresent());
        assertFalse(parent.getChildren().isEmpty());
        assertSame(child, parent.getChild("UK").get());
        assertSame(parent, child.getParent().get());
    }

    /*
    Given I have a region Africa ("Africa", "Continental Africa")
    When I add a location Table Mountain to Africa
    Then I expect Africa to have Table Mountain as a child
    And I expect Table Mountain to have Africa as parent
     */
    @Test
    public void verifyAddingParentToLocation() {
        Region africa = Region.create("Africa", "Contenential Africa").getObject();
        Validation<Location> locationValidation = Location.create("TableMountain", "Table " +
                "Mountain", 33, 58, 18.6132, 'S', 18, 24, 33.5124, 'E',
                AbstractTemperatureScale.Fahrenheit, africa);
        assertTrue(locationValidation.isPresent());
        assertTrue(locationValidation.getObject().getParent().isPresent());
        assertSame(africa, locationValidation.getObject().getParent().get());
        assertSame(locationValidation.getObject(), africa.getChild("TableMountain").get());
    }

    /*
    Given I have created a number of regions with some parent relationships
    When I ask for all regions
    Then I should get an array containing all regions
    When I ask for all region names
    Then I should get an array containing all the names of the regions
     */
    @Test
    public void verifySetOfRegions() {
        Region africa = Region.create("Africa", "Contenential Africa").getObject();
        Region europe = Region.create("Europe", "Geographical Europe").getObject();
        Region uk = Region.create("UK", "United Kingdom", europe).getObject();
        Region nz = Region.create("NZ", "New Zealand").getObject();

        assertEquals(4, Region.getRegions().length);
        assertEquals(4, Region.getRegionsNames().length);
        assertTrue( Region.findRegion("NZ").isPresent());
        assertTrue( Region.findRegion("Africa").isPresent());
        assertTrue( Region.findRegion("Europe").isPresent());
        assertTrue( Region.findRegion("UK").isPresent());
        assertFalse( Region.findRegion("Fred").isPresent());
    }
}
