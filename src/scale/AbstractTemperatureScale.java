package scale;

import temperature.Temperature;

/**
 * @author thompel1
 * @version 27/11/2017 13:04
 */
public abstract class AbstractTemperatureScale implements TemperatureScale {
    public static final TemperatureScale Celsius = new CelsiusScale();
    public static final TemperatureScale Kelvin = new KelvinScale();
    public static final TemperatureScale Fahrenheit = new FahrenheitScale();

    public static final TemperatureScale[] temperatureScales = {Celsius, Kelvin, Fahrenheit};

    protected Model model;
    /**
     * Calculates the average temperature from the entered temperatures
     */
    @Override
    public void calculateAverage() {
        ArrayList<Temperature> temperatures = model.getTemperatures();
        if (temperatures.isEmpty()) {
            setAverageTemperature(0);
        } else {
            double total = 0.0;
            for (Temperature temp : temperatures) {
                total += getTemperature(temp);
            }
            setAverageTemperature(total / temperatures.size());
        }
    }

    abstract void setAverageTemperature(double temperature);

    abstract double getTemperature(Temperature temp);

    /**
     * Creates a temperature object
     */
    @Override
    public abstract void createTemperature();
}
