/**
 * This class represents a Latitude coordinate based on the standard degrees, minutes, and
 * seconds notation.
 *
 * @author ET
 * @version 29/08/2019 14:40
 */
public class Latitude {
    private Coordinate coordinate;

    /**
     * A constructor that takes in degrees, minutes, seconds, and a direction. The constructor is
     * private to enforce use of one of the factory methods at the end of the class.
     *
     * @param degrees an integer degree value
     * @param minutes an integer minutes value
     * @param seconds a double seconds value
     * @param direction a direction character that should be 'N' and 'S'.
     */
    private Latitude(int degrees, int minutes, double seconds, char direction) {
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
    private Latitude(int degrees, int minutes, double seconds) {
        coordinate = new Coordinate(degrees, minutes, seconds);
    }

    /**
     * A constructor that takes in degrees. The constructor is private to enforce use of one of
     * the factory methods at the end of the class.
     *
     * @param degrees a double degrees value
     */
    private Latitude(double degrees) {
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
     * Retrieves the direction character that represents South or North.
     *
     * @return either 'S' for South or 'N' for North
     */
    public char getDirection() {
        return getDegrees() <0 ? 'S': 'N';
    }

    /**
     * This is a factory method for the creation of Latitude objects from degrees, minutes,
     * seconds, and a direction. It returns a Validation object that contains a valid Latitude if
     * the parameters are valid or an appropriate error message if the values are invalid.
     *
     * @param degrees an integer degree value
     * @param minutes an integer minutes value
     * @param seconds a double seconds value
     * @param direction a direction character that should be 'N' and 'S'.
     * @return a Validation object that either contains a valid Latitude object or an error message
     */
    public static Validation<Latitude> create(int degrees, int minutes, double seconds, char direction) {
        if (degrees < 0 || degrees > 90 || (degrees == 90 && (seconds != 0 || minutes != 0)))  {
            return new Validation<>("Latitude degree value out of range should be between 0 and " +
                    "90");
        }
        if (direction != 'S' && direction != 'N') {
            return new Validation<>("Latitude direction should be 'S' or 'N'");
        }
        String errorMessage = Coordinate.validateMinutesAndSeconds(minutes, seconds,
                Coordinate.LatOrLongitude.Latitude);
        if (errorMessage != null) return new Validation<>(errorMessage);
        return new Validation<>(new Latitude(degrees, minutes, seconds, direction));
    }

    /**
     * This is a factory method for the creation of Latitude objects from degrees, minutes, and
     * seconds. It returns a Validation object that contains a valid Latitude if the parameters
     * are valid or an appropriate error message if the values are invalid.
     *
     * @param degrees an integer degree value
     * @param minutes an integer minutes value
     * @param seconds a double seconds value
     * @return a Validation object that either contains a valid Latitude object or an error message
     */
    public static Validation<Latitude> create(int degrees, int minutes, double seconds) {
        if (Math.abs(degrees) > 90 || (Math.abs(degrees) == 90 && (seconds != 0 || minutes != 0)))  {
            return new Validation<>("Latitude degree value out of range should be between -90 and" +
                    " 90");
        }
        String errorMessage = Coordinate.validateMinutesAndSeconds(minutes, seconds,
                Coordinate.LatOrLongitude.Latitude);
        if (errorMessage != null) return new Validation<>(errorMessage);
        return new Validation<Latitude>(new Latitude(degrees, minutes, seconds));
    }

    /**
     * This is a factory method for the creation of Latitude objects from degrees. It returns a
     * Validation object that contains a valid Latitude if the parameters are valid or an
     * appropriate error message if the values are invalid.
     *
     * @param degrees an integer degree value
     * @return a Validation object that either contains a valid Latitude object or an error message
     */
    public static Validation<Latitude> create(double degrees) {
        if (Math.abs(degrees) > 90)  {
            return new Validation<>("Latitude degree value out of range should be between -90 and" +
                    " 90");
        }
        return new Validation<Latitude>(new Latitude(degrees));
    }
}
