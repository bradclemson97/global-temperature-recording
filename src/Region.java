import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

/**
 * @author ET
 * @version 03/09/2019 16:18
 */
public class Region extends AbstractRegion {
    private HashMap<String, AbstractRegion> children = new HashMap<>();
    private static HashMap<String, Region> regions = new HashMap<>();

    /**
     * Constructor for a region
     *
     * @param name a unique name for the region
     * @param description the region's description
     */
    public Region(String name, String description) {
        super(name, description, null);
        regions.put(name, this);
    }

    /**
     * Constructor for creating a region with a parent region
     *
     * @param name of the region
     * @param description of the region
     * @param parent region of the region
     */
    public Region(String name, String description, Region parent) {
        super(name, description, parent);
        regions.put(name, this);
    }

    /**
     * Method to add child region or a location to this region. This method should never be
     * called directly. It is here so the constructor can ask the parent (if present) to add the
     * location or region as a child.
     *
     * @param abstractRegion a region or location object that has this region as its parent
     */
    void add(AbstractRegion abstractRegion) {
        children.put(abstractRegion.getName(), abstractRegion);
    }

    /**
     * Retrieves the collection of child regions or locations
     *
     * @return a collection of child regions or locations
     */
    public Collection<AbstractRegion> getChildren() {
        return children.values();
    }

    /**
     * Retrieves the child region or location based on the name passed to it.
     *
     * @param name of the region or location
     * @return an Optional containing the region or location matching the name or an empty optional
     */
    public Optional<AbstractRegion> getChild(String name) {
        return Optional.ofNullable(children.get(name));
    }

    /**
     * Retrieves an array of all the regions that have been created
     *
     * @return an array of all the regions that have been created
     */
    public static Region[] getRegions() {
        return regions.values().toArray(new Region[0]);
    }

    /**
     * Retrieves an array of the names of all the regions that have been created
     *
     * @return an array of the names of all the regions that have been created
     */
    public static String[] getRegionsNames() {
        return regions.keySet().toArray(new String[0]);
    }

    /**
     * Retreives an Optional region based on the name value passed in
     *
     * @param name of the region to be found
     * @return an Optional containing the region or an empty optional
     */
    public static Optional<Region> findRegion(String name) {
        return Optional.ofNullable(regions.get(name));
    }

    /**
     * Creates a region that has no parent region
     *
     * @param name of the region to be created
     * @param description of the region to be created
     * @return a Validation object that contains the created region or error messages if the
     * region was not created.
     */
    public static Validation<Region> create(String name, String description) {
        String errorMessage = verifyNameAndDescription(name, description, RegionOrLocation.REGION);
        if (errorMessage.length() != 0) {
            return new Validation<>(errorMessage);
        }
        return new Validation<>(new Region(name, description));
    }

    /**
     * Creates a region with a parent region.
     *
     * @param name of the region to be created
     * @param description of the region to be created
     * @param parent a reference to the parent region
     * @return a Validation object that contains the created region or error messages if the
     * region was not created.
     */
    public static Validation<Region> create(String name, String description, Region parent) {
        String errorMessage = concatErrors(verifyNameAndDescription(name, description, RegionOrLocation.REGION), parent == null ? "No parent region provided": "");
        if (errorMessage.length() != 0) {
            return new Validation<>(errorMessage);
        }
        return new Validation<>(new Region(name, description, parent));
    }
}
