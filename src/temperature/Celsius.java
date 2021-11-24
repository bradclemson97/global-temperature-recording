package temperature;

/**
 * Class handles Celsius temperatures
 * Objects created from this class are immutable
 * that is the value given in the constructor can not be changed
 * there are no setter methods.
 *
 * @author Dr Thompson
 * @version 2010-10-26
 */
public class Celsius implements Temperature {
    private double temperature;

    /**
     * Constructor that accepts a Celsius model.temperature
     *
     * @param pTemperature model.temperature
     */
    public Celsius(double pTemperature) {
        temperature = pTemperature;
    }

    /**
     * A getter method to retrieve the current value as
     *
     * @return Fahrenheit model.temperature value
     */
    public double getFahrenheit() {
        return temperature * 1.8 + 32;
    }

    /**
     * A getter method to retrieve the current value as
     *
     * @return Celsius model.temperature value
     */
    public double getCelsius() {
        return temperature;
    }

    /**
     * A getter method to retrieve the current value as
     *
     * @return Kelvin model.temperature value
     */
    public double getKelvin() {
        return temperature + 273.15;
    }

    /**
     * Overrides default toString so that it uses the correct toString
     * method fro the Celsius model.temperature scale
     *
     * @return temperature string
     */
    @Override
    public String toString() {
        return toCelsiusString();
    }

    /**
     * Produce a string of the form nn°F
     * This is a getter style function
     *
     * @return a string containing a formatted Fahrenheit temperature
     */
    public String toFahrenheitString() {
        return getFahrenheit() + FAHRENHEIT_STRING;
    }

    /**
     * Produce a string of the form nn°C
     * This is a getter style function
     *
     * @return a string containing a formatted Celsius temperature
     */
    public String toCelsiusString() {
        return getCelsius() + CELSIUS_STRING;
    }

    /**
     * Produce a string of the form nn°K
     *
     * @return a string containing a formatted Kelvin temperature
     */
    public String toKelvinString() {
        return getKelvin() + KELVIN_STRING;
    }
}
