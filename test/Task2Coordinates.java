import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ET
 * @version 2019-08-23 09:14
 */
public class Task2Coordinates {
    /**
     * Given a coordinate for Greenwich of 0, 0, 0.0, 'E'
     * When I have created the coordinate
     * Then the degrees should be 0
     * And the minutes should be 0
     * And the seconds should be 0
     * And the double degrees value should be 0.0
     *
     * Given a coordinate for Greenwich of 51, 28, 40.1412, 'N'
     * When I have created the coordinate
     * Then the degrees should be 51
     * And the minutes should be 28
     * And the seconds should be 40.1412
     * And the double degrees value should be 51.477817
     */
    @Test
    public void CoordinateGreenwich() {
        Coordinate coordinate = new Coordinate(0, 0, 0.0, 'E');
        assertEquals(0, coordinate.getDegrees());
        assertEquals(0, coordinate.getMinutes());
        assertEquals(0.0,coordinate.getSeconds(), 0.00);
        assertEquals(0.0, coordinate.getDMSDegree(), 0.0);

        coordinate = new Coordinate(51, 28, 40.1412, 'N');
        assertEquals(51, coordinate.getDegrees());
        assertEquals(28, coordinate.getMinutes());
        assertEquals(40.1412,coordinate.getSeconds(), 0.0001);
        assertEquals(51.477817, coordinate.getDMSDegree(), 0.0);
    }

    /**
     * Given a coordinate for Aston University of 1, 53, 24.1254, 'E'
     * When I have created the coordinate
     * Then the degrees should be -1
     * And the minutes should be 53
     * And the seconds should be 24.1254
     * And the double degrees value should be -1.890035
     *
     * Given a coordinate of 4, 10, 0.09, 'S"
     * When I have created the coordinate
     * Then the degrees should be -4
     * And the minutes should be 10
     * And the seconds should be 0.09
     * And the double degrees value should be -4.16669
     */
    @Test
    public void CoordinateAston() {
        Coordinate coordinate = new Coordinate(1, 53, 24.1254, 'W');
        assertEquals(-1, coordinate.getDegrees());
        assertEquals(53, coordinate.getMinutes());
        assertEquals(24.1254,coordinate.getSeconds(), 0.0001);
        assertEquals(-1.890035, coordinate.getDMSDegree(), 0.0001);

        coordinate = new Coordinate(4, 10, 0.09, 'S');
        assertEquals(-4, coordinate.getDegrees());
        assertEquals(10, coordinate.getMinutes());
        assertEquals(0.09,coordinate.getSeconds(), 0.0001);
        assertEquals(-4.16669, coordinate.getDMSDegree(), 0.0001);

    }

    /**
     * Given a coordinate for Table Mountain in South Africa of 18, 24, 33.5124
     * When I have created the coordinate
     * Then the degrees should be 18
     * And the minutes should be 24
     * And the seconds should be 33.5124
     * And the double degrees value should be 18.409309
     *
     * Given a coordinate for Table Mountain in South Africa of -33, 58, 18.6132
     * When I have created the coordinate
     * Then the degrees should be -33
     * And the minutes should be 58
     * And the seconds should be 18.6132
     * And the double degrees value should be -33.971837
     */
    @Test
    public void CoordinateTableMountain() {
        Coordinate coordinate = new Coordinate(18, 24, 33.5124);
        assertEquals(18, coordinate.getDegrees());
        assertEquals(24, coordinate.getMinutes());
        assertEquals(33.5124,coordinate.getSeconds(), 0.0001);
        assertEquals(18.409309, coordinate.getDMSDegree(), 0.0001);

        coordinate = new Coordinate(-33, 58, 18.6132);
        assertEquals(-33, coordinate.getDegrees());
        assertEquals(58, coordinate.getMinutes());
        assertEquals(18.6132,coordinate.getSeconds(), 0.0001);
        assertEquals(-33.971837, coordinate.getDMSDegree(), 0.0001);
    }

    /**
     * Given a coordinate for Wellington Airport of 174.782099
     * When I have created the coordinate
     * Then the degrees should be 174
     * And the minutes should be 46
     * And the seconds should be 55.5558
     * And the double degrees value should be 174.782099
     *
     * Given a coordinate for Wellington Airport of -41.290485
     * When I have created the coordinate
     * Then the degrees should be -41
     * And the minutes should be 17
     * And the seconds should be 25.7454
     * And the double degrees value should be -41.290485
     */
    @Test
    public void WellingtonAirport() {
        Coordinate coordinate = new Coordinate(174.782099);
        assertEquals(174, coordinate.getDegrees());
        assertEquals(46, coordinate.getMinutes());
        assertEquals(55.5558,coordinate.getSeconds(), 0.01);
        assertEquals(174.782099, coordinate.getDMSDegree(), 0.0001);

        coordinate = new Coordinate(-41.290485);
        assertEquals(-41, coordinate.getDegrees());
        assertEquals(17, coordinate.getMinutes());
        assertEquals(25.7454,coordinate.getSeconds(), 0.01);
        assertEquals(-41.290485, coordinate.getDMSDegree(), 0.0001);
    }

    /**
     * Given a coordinate of -0.1
     * When I have created the coordinate
     * Then the degrees should be -0
     * And the minutes should be 6
     * And the seconds should be 0.0
     * And the double degrees value should be -0.1
     *
     * Given a coordinate of 0, 6, 0.00, 'S'
     * When I have created the coordinate
     * Then the degrees should be -0
     * And the minutes should be 6
     * And the seconds should be 0.00
     * And the double degrees value should be -0.1
     */
    @Test
    public void verifyNegativeZeroDegrees() {
        Coordinate coordinate = new Coordinate(-0.1);
        assertEquals(-0, coordinate.getDegrees());
        assertEquals(6, coordinate.getMinutes());
        assertEquals(0.0,coordinate.getSeconds(), 0.01);
        assertEquals(-0.1, coordinate.getDMSDegree(), 0.0001);

        coordinate = new Coordinate(0, 6, 0.00, 'S');
        assertEquals(-0, coordinate.getDegrees());
        assertEquals(6, coordinate.getMinutes());
        assertEquals(0.00,coordinate.getSeconds(), 0.0001);
        assertEquals(-0.1, coordinate.getDMSDegree(), 0.0001);
    }
}
