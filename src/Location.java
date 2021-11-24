import scale.TemperatureScale;

/**
 * This class is designed to represent a location within the system.
 *
 * @author ET
 * @version 30/08/2019 14:45
 */
public class Location extends AbstractRegion {
    private final Latitude latitude;
    private final Longitude longitude;
    private final TemperatureScale temperatureScale;

    /**
     * A constructor that initialises a Location object. It is marked private to ensure use of an
     * appropriate factory method to validate the values before creation.
     *  @param name is a unique name for the location
     * @param description is a description for the location
     * @param latitude is a reference to a Latitude object representing the latitude of the
 *                 location
     * @param longitude is a reference to a Longitude object representing the longitude of the
*                  location
     * @param temperatureScale is a reference to a TemperatureScale object representing the
     * @param region
     */
    private Location(String name, String description, Latitude latitude,
                     Longitude longitude, TemperatureScale temperatureScale, Region region) {
        super(name, description, region);
        this.latitude = latitude;
        this.longitude = longitude;
        this.temperatureScale = temperatureScale;
    }

    /**
     * Retrieves the Latitude defined for the location.
     *
     * @return a Latitude object that contains the latitude for the location
     */
    public Latitude getLatitude() {
        return latitude;
    }

    /**
     * Retrieves the Longitude defined for the location.
     *
     * @return a longitude object that contains the longitude for the location
     */
    public Longitude getLongitude() {
        return longitude;
    }

    /**
     * Retrieves the default temperature scale object for the location
     *
     * @return a TemperatureScale object that represents the default temperature scale being used
     * for the location
     */
    public TemperatureScale getTemperatureDefaultScale() {
        return temperatureScale;
    }

    /**
     * This is a factory method for creating a Location object. It validates the parameters passed
     * in and will return either a Validation object containing either a Location object or an
     * error message.
     *
     * <b>Note:</b> The coordinate values are validated by creating the appropriate Latitude and
     * Longitude objects.
     *
     * @param name This should be a unique name for the location. Currently it is only
     *                      validated to ensure that it is not blank.
     * @param description This is a longer description of the location. It is validated to ensure
     *                   that it is not empty.
     * @param latDegrees the degrees for the latitude
     * @param latMinutes the minutes for the latitude
     * @param latSeconds the seconds for the latitude
     * @param latDirection the latitude direction (i.e. 'N' or 'S'
     * @param longDegrees the degrees for the longitude
     * @param longMinutes the minutes for the longitude
     * @param longSeconds the seconds for the longitude
     * @param longDirection the direction for the longitude (i.e. 'E' or 'W')
     * @param temperatureScale the default temperature scale for the location. This is validated
     *                         to ensure that it is not null.
     * @param region
     * @return A Validation object that either contains a valid Location object or an error
     * message.
     */
    public static Validation<Location> create(String name, String description,
                                              int latDegrees, int latMinutes, double latSeconds, char latDirection,
                                              int longDegrees, int longMinutes, double longSeconds, char longDirection,
                                              TemperatureScale temperatureScale, Region region) {
        Validation<Latitude> latitudeValid = Latitude.create(latDegrees, latMinutes, latSeconds,
                latDirection);
        Validation<Longitude> longitudeValid = Longitude.create(longDegrees, longMinutes, longSeconds,
                longDirection);
        String errorMessage =  concatErrors(latitudeValid.getErrorMessage(),
                longitudeValid.getErrorMessage());
        errorMessage = concatErrors(errorMessage, verifyNameAndDescription(name,
                description, RegionOrLocation.LOCATION));
        errorMessage = concatErrors(errorMessage, temperatureScale == null ?
                "No temperature scale selected": "");
        errorMessage = concatErrors(errorMessage, region == null ? "No region is provided" : "");
        if(errorMessage.length() != 0) {
            return new Validation<>(errorMessage);
        }
        Latitude latitude = latitudeValid.getObject();
        Longitude longitude = longitudeValid.getObject();
        return new Validation<>(new Location(name, description, latitude, longitude,
                temperatureScale, region));
    }
}
