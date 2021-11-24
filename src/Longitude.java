/**
 * This class represents a Longitude coordinate based on the standard degrees, minutes, and
 *  * seconds notation.
 *
 * @author ET
 * @version 29/08/2019 14:40
 */
public class Longitude {
    private Coordinate coordinate;

    /**
     * A constructor that takes in degrees, minutes, seconds, and a direction. The constructor is
     * private to enforce use of one of the factory methods at the end of the class.
     *
     * @param degrees an integer degree value
     * @param minutes an integer minutes value
     * @param seconds a double seconds value
     * @param direction a direction character that should be 'E' and 'W'.
     */
    private Longitude(int degrees, int minutes, double seconds, char direction) {
        coordinate = new Coordinate(degrees, minutes, seconds, direction);
    }

    /**
     * A constructor that takes in degrees, minutes, and seconds. The constructor is private to
     * enforce use of one of the factory methods at the end of the class.
     *
     * @param degrees an integer degree value
     * @param minutes an integer minutes value
     * @param seconds a double seconds value
     */
    private Longitude(int degrees, int minutes, double seconds) {
        coordinate = new Coordinate(degrees, minutes, seconds);
    }

    /**
     * A constructor that takes in degrees. The constructor is private to enforce use of one of
     * the factory methods at the end of the class.
     *
     * @param degrees a double degrees value
     */
    private Longitude(double degrees) {
        coordinate = new Coordinate(degrees);
    }

    /**
     * Retrieves an integer degrees value. This assumes that you will also request a minutes and
     * seconds value. This value can be negative or positive.
     *
     * @return an integer degrees value (+ve or -ve)
     */
    public int getDegrees() {
        return coordinate.getDegrees();
    }

    /**
     * Retrieves an integer minutes value. This assumes that you will also request a degrees and
     * seconds value. The value is always positive.
     *
     * @return an integer minutes value
     */
    public int getMinutes() {
        return coordinate.getMinutes();
    }

    /**
     * Retrieves a double seconds value. This assumes that you will also request a degrees and
     * minutes value. The value is always positive.
     *
     * @return a double seconds value.
     */
    public double getSeconds() {
        return coordinate.getSeconds();
    }

    /**
     * Retrieves the double degrees value. The fractional part represents the degrees and minutes.
     *
     * @return a double degrees value.
     */
    public double getDMSDegree() {
        return coordinate.getDMSDegree();
    }

    /**
     * Retrieves the direction character that represents East or West.
     *
     * @return either 'E' for East or 'W' for West
     */
    public char getDirection() {
        return getDegrees() >= 0 ? 'E': 'W';
    }

    /**
     * This is a factory method for the creation of Longitude objects from degrees, minutes,
     * seconds, and a direction. It returns a Validation object that contains a valid Longitude if
     * the parameters are valid or an appropriate error message if the values are invalid.
     *
     * @param degrees an integer degree value
     * @param minutes an integer minutes value
     * @param seconds a double seconds value
     * @param direction a direction character that should be 'N' and 'S'.
     * @return a Validation object that either contains a valid Longitude object or an error message
     */
    public static Validation<Longitude> create(int degrees, int minutes, double seconds,
                                               char direction) {
        if (degrees < 0 || degrees > 180 || (degrees == 180 && (seconds != 0 || minutes != 0))) {
            return new Validation<>("Longitude degree value out of range should be between 0 and 180");
        }
        if (direction != 'E' && direction != 'W') {
            return new Validation<>("Longitude direction should be 'E' or 'W'");
        }
        String errorMessage = Coordinate.validateMinutesAndSeconds(minutes, seconds,
                Coordinate.LatOrLongitude.Longitude);
        if (errorMessage != null) return new Validation<>(errorMessage);
        return new Validation<>(new Longitude(degrees, minutes, seconds, direction));
    }

    /**
     * This is a factory method for the creation of Longitude objects from degrees, minutes, and
     * seconds. It returns a Validation object that contains a valid Longitude if the parameters
     * are valid or an appropriate error message if the values are invalid.
     *
     * @param degrees an integer degree value
     * @param minutes an integer minutes value
     * @param seconds a double seconds value
     * @return a Validation object that either contains a valid Longitude object or an error message
     */
    public static Validation<Longitude> create(int degrees, int minutes, double seconds) {
        if (Math.abs(degrees) > 180 || (Math.abs(degrees) == 180 && (seconds != 0 || minutes != 0))) {
            return new Validation<>("Longitude degree value out of range should be between -180 and 180");
        }
        String errorMessage = Coordinate.validateMinutesAndSeconds(minutes, seconds,
                Coordinate.LatOrLongitude.Longitude);
        if (errorMessage != null) return new Validation<>(errorMessage);
        return new Validation<>(new Longitude(degrees, minutes, seconds));
    }

    /**
     * This is a factory method for the creation of Longitude objects from degrees. It returns a
     * Validation object that contains a valid Longitude if the parameters are valid or an
     * appropriate error message if the values are invalid.
     *
     * @param degrees an integer degree value
     * @return a Validation object that either contains a valid Longitude object or an error message
     */
    public static Validation<Longitude> create(double degrees) {
        if (Math.abs(degrees) > 180) {
            return new Validation<>("Longitude degree value out of range should be between -180 " +
                    "and 180");
        }
        return new Validation<>(new Longitude(degrees));
    }
}
