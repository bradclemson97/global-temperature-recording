import java.util.Optional;

/**
 * @author ET
 * @version 03/09/2019 16:20
 */
public abstract class AbstractRegion {

    protected final String name;
    protected final String description;
    private Region parent;

    protected enum RegionOrLocation {
        REGION, LOCATION
    }

    /**
     * Constructor for initialising the shared fields
     *
     * @param name the name of the region or location
     * @param description the description of the region or location
     * @param parent a reference to the parent region or null if there is no parent region
     */
    public AbstractRegion(String name, String description, Region parent) {
        this.name = name;
        this.description = description;
        this.parent = parent;
        if(parent != null) {
            parent.add(this);
        }
    }

    /**
     * Retrieve the name for the region or location
     *
     * @return the region's or location's name
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieve the description of the region or location
     *
     * @return the region's or location's name
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retrieve the parent region for a region or location
     *
     * @return the region's or location's parent
     */
    public Optional<Region> getParent() {
        return Optional.ofNullable(parent);
    }

    /**
     * Verifies that a region or location has been given a name and description
     *
     * @param name the name to be assigned to the region or location
     * @param description the description to be assigned to the region or location
     * @param regionOrLocation signals whether this is a region or location being created
     * @return an empty string or the appropriate error message if no name or description is
     * provided
     */
    static String verifyNameAndDescription(String name, String description, RegionOrLocation regionOrLocation) {
        return concatErrors(isPresent(name,
                "No " + regionOrLocation.name().toLowerCase() + " name provided."),
                isPresent(description, "No " + regionOrLocation.name().toLowerCase() +
                        " description provided."));
    }

    /**
     * Function to verify whether a string is present and return an error message if it is not.
     *
     * @param string the string that should be present
     * @param errorMessage the error message to be used if it is not present
     * @return return and empty string if the string being validated exists and the error message
     * if it does not.
     */
    private static String isPresent(String string, String errorMessage) {
        if (string == null || string.length() == 0) { return errorMessage; }
        return "";
    }

    /**
     * Concatenates error messages inserting an end of line character if both exist.
     *
     * @param errorMessage first error message. This is assumed not to be null
     * @param newErrorMessage second error message. This is assumed not to be null
     * @return concatenated messages
     */
    static String concatErrors(String errorMessage, String newErrorMessage) {
        return errorMessage + (errorMessage.length() == 0 || newErrorMessage.length() == 0 ? "":
                "\n") + newErrorMessage;
    }
}
