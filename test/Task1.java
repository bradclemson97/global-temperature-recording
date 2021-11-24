import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The functions to implement are:
 *
 *   Celsius to Fahrenheit    ->    c * 9 / 5 + 32
 *  Fahrenheit to Kelvin     ->    f - 32 * 5 / 9 + 273.15
 *  Kelvin to Celsius        ->    k - 273.15
 *
 * @author ET
 * @version 2019-08-21 09:19
 */
public class Task1 {

    private static final double CELSIUS_KELVIN_FACTOR = 272.15;
    private static final double CELSIUS_FAJRENHEIT_ADDITION = 32.0;

    /**
     * Give a Celsius temperature of 0
     * When I convert to Fahrenheit
     * Then the fahrenheit temperature should be 32
     *
     * Give a Celsius temperature of 100
     * When I convert to Fahrenheit
     * Then the fahrenheit temperature should be 212.0
     *
     * Give a Celsius temperature of 50
     * When I convert to Fahrenheit
     * Then the fahrenheit temperature should be 122.0
     */
    @Test
    public void CtoFTests() {
        assertEquals(32.0, getFahrenheit(0.0), 0.01);
        assertEquals(212.0, getFahrenheit(100.0), 0.01);
        assertEquals(122.0, getFahrenheit(50.0), 0.01);
    }

    /**
     * Convert Celsius to Fahrenheit
     * @param celsius Celsius temperature
     * @return Fahrenheit
     */
    private double getFahrenheit(double celsius) {
        return celsius * 9.0 / 5.0 + CELSIUS_FAJRENHEIT_ADDITION;
    }

    /**
     * Give a Fahrenheit temperature of 32
     * When I convert to Kelvin
     * Then the Kelvin temperature should be 272.15
     *
     * Give a Fahrenheit temperature of 212.0
     * When I convert to Kelvin
     * Then the Kelvin temperature should be 372.15
     *
     * Give a Fahrenheit temperature of 122.0
     * When I convert to Kelvin
     * Then the Kelvin temperature should be 322.15
     */
    @Test
    public void FtoKTests() {
        assertEquals(272.15, getKelvin(32.0), 0.01);
        assertEquals(372.15, getKelvin(212.0), 0.01);
        assertEquals(322.15, getKelvin(122.0), 0.01);
    }

    /**
     * Convert Fahrenheit to Kelvin
     *
     * @param fahrenheit Fahrenheit temperature
     * @return Kelvin temperature
     */
    private double getKelvin(double fahrenheit) {
        return getCelsiusFromFahrenheit(fahrenheit) + CELSIUS_KELVIN_FACTOR;
    }

    /**
     * Give a Fahrenheit temperature of 32
     * When I convert to Celsius
     * Then the Celsius temperature should be 0.0
     *
     * Give a Fahrenheit temperature of 212.0
     * When I convert to Celsius
     * Then the Celsius temperature should be 100.00
     *
     * Give a Fahrenheit temperature of 122.0
     * When I convert to Celsius
     * Then the Celsius temperature should be 50.0
     */
    @Test
    public void FtoCTest() {
        assertEquals(0.0, getCelsiusFromFahrenheit(32.0), 0.01);
        assertEquals(100.0, getCelsiusFromFahrenheit(212.0), 0.01);
        assertEquals(50.0, getCelsiusFromFahrenheit(122.0), 0.01);
    }

    /**
     * Convert Fahrenheit to Celsius
     *
     * @param fahrenheit Fahrenheit temperature
     * @return Celsius temperature
     */
    private double getCelsiusFromFahrenheit(double fahrenheit) {
        return (fahrenheit - CELSIUS_FAJRENHEIT_ADDITION) * 5.0 / 9.0;
    }

    /**
     * Give a Kelvin temperature of 272.15
     * When I convert to Celsius
     * Then the Celsius temperature should be 0.0
     *
     * Give a Kelvin temperature of 372.15
     * When I convert to Celsius
     * Then the Celsius temperature should be 100.00
     *
     * Give a Kelvin temperature of 322.15
     * When I convert to Celsius
     * Then the Celsius temperature should be 50.0
     */
    @Test
    public void KtoCTest() {
        assertEquals(0.0, getCelsius(272.15), 0.0);
        assertEquals(100.00, getCelsius(372.15), 0.0);
        assertEquals(50.0, getCelsius(322.15), 0.0);
    }

    /**
     * Convert Kevin to Celsius
     *
     * @param kelvin Kelvin temperature
     * @return Celsius temperature
     */
    private double getCelsius(double kelvin) {
        return kelvin - CELSIUS_KELVIN_FACTOR;
    }
}
