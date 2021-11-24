package scale;

/**
 * Interface for temperature scale objects.
 * These objects return the scale name through the toString method
 * and include a function for calculating the average for the temperatures
 * using the selected scale.
 *
 * @author Mr Thompson
 */
public interface TemperatureScale {

    /**
     * Calculates the average temperature from the entered temperatures
     */
    void calculateAverage();

    /**
     * Creates a temperature object
     */
    void createTemperature();

    /**
     * Used by the combobox to display the name of the temperature scale
     *
     * @return the name of the temperature scale
     */
    @Override
    String toString();
}