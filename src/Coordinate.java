/**
 * This class is used for storing the numbers that make up a latitude or a longitude. Internally,
 * it holds the value as a double degrees.
 *
 * <b>NOTE:</b> Coordinate objects do not know whether they are representing a longitude or a
 * latitude so can not supply a direction character.
 *
 * There is an issue with the setting of a coordinate value where the degrees are 0 but the
 * minutes and seconds are in a negative direction. -0 is treated as 0 when using the double type.
 *
 * There is also no validation done in this class. It assumes that it is used as a delegate of
 * either a Longitude or Latitude object.
 *
 * @author ET
 * @version 2019-08-23 09:16
 */
public class Coordinate {
    private final double degrees;

    public enum LatOrLongitude {
        Latitude, Longitude
    }

    /**
     * A constructor that takes in degrees, minutes, seconds, and a direction.
     *
     * @param degree an integer degree value
     * @param minutes an integer minutes value
     * @param seconds a double seconds value
     * @param direction a direction character. 'E' and 'S' will change the degrees to a negative
     *                  value.
     */
    public Coordinate(int degree, int minutes, double seconds, char direction) {
        this.degrees = (degree + (minutes / 60.0) + (seconds / 3600.0)) *
                (direction == 'W' || direction == 'S' ? -1 : 1);
    }

    /**
     * A constructor that takes in degrees, minutes, and seconds.
     *
     * @param degree an integer degree value
     * @param minutes an integer minutes value
     * @param seconds a double seconds value
     */
    public Coordinate(int degree, int minutes, double seconds) {
        this.degrees = degree + ((minutes / 60.0) + (seconds / 3600.0)) * (degree < 0 ? -1 : 1);
    }

    /**
     * A constructor that takes in degrees.
     *
     * @param degrees a double degrees value
     */
    public Coordinate(double degrees) {
        this.degrees = degrees;
    }

    /**
     * Retrieves an integer degrees value. This assumes that you will also request a minutes and
     * seconds value. This value can be negative or positive.
     *
     * @return an integer degrees value (+ve or -ve)
     */
    public int getDegrees() {
        return (int) degrees;
    }

    /**
     * Retrieves an integer minutes value. This assumes that you will also request a degrees and
     * seconds value. The value is always positive.
     *
     * @return an integer minutes value
     */
    public int getMinutes() {
        return (int) (Math.abs(degrees - getDegrees()) * 60);
    }

    /**
     * Retrieves a double seconds value. This assumes that you will also request a degrees and
     * minutes value. The value is always positive.
     *
     * @return a double seconds value.
     */
    public double getSeconds() {
        return ((Math.abs(degrees - getDegrees()) * 60) - getMinutes()) * 60;
    }

    /**
     * Retrieves the double degrees value. The fractional part represents the degrees and minutes.
     *
     * @return a double degrees value.
     */
    public double getDMSDegree() {
        return degrees;
    }

    /**
     * This method is designed to be used in conjunction with the factory methods for creating
     * Latitudes and Longitudes. It validates the minutes and seconds portion of a Latitude or
     * Longitude coordinate.
     *
     * The minutes should be a value between 0 and 60.
     *
     * The seconds should be a value between 0.0 and 60.0
     *
     * @param minutes an integer minutes value
     * @param seconds a double seconds value
     * @param latOrLongitude whether this is validating for a latitude or longitude object
     * @return null if the values are within range or a Validation object containing an error
     * message
     */
    static String validateMinutesAndSeconds(int minutes, double seconds, LatOrLongitude latOrLongitude) {
        if (minutes < 0 || minutes > 60 || (minutes == 60 && (seconds != 0))) {
            return latOrLongitude.name() + " minutes out of range should be between 0 and 60 inclusive";
        }
        if (seconds < 0.0 || seconds > 60.0) {
            return latOrLongitude.name() + " seconds out of range should be between 0 and 60 inclusive";
        }
        return null;
    }
}
