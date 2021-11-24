package temperature;

/**
 * Temperature Interface
 * Defines the expected behaviour for a model.temperature class
 *
 * @author Mr Thompson
 */
public interface Temperature {

    String CELSIUS_STRING = "°C";
    String KELVIN_STRING = "°K";
    String FAHRENHEIT_STRING = "°F";
    double CELSIUS_TO_KELVIN = 273.15;

    /**
     * Calculates or returns the Fahrenheit model.temperature value
     * 
     * @return Fahrenheit model.temperature value
     */
    double getFahrenheit();

    /**
     * Calculates or returns the Celsius model.temperature value
     *
     * @return Celsius model.temperature value
     */
    double getCelsius();

    /**
     * A getter method to retrieve the current value as
     *
     * @return Kelvin model.temperature value
     */
    public double getKelvin();

    /**
     * Produce a string of the form nn°F
     *
     * @return a string containing a formatted Fahrenheit date
     */
    String toFahrenheitString();

    /**
     * Produce a string of the form nn°C
     *
     * @return a string containing a formatted Celsius date
     */
    String toCelsiusString();

    /**
     * Produce a string of the form nn°C
     *
     * @return a string containing a formatted Celsius date
     */
    String toKelvinString();
}