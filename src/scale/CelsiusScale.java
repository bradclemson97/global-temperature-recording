package scale;

import temperature.Temperature;

/**
 * Celsius scale class
 *
 * @author Dr ET
 */
public class CelsiusScale extends AbstractTemperatureScale {

    /**
     * Constructor for Abstract temperature scale
     *
     * @param model is the data model for the application
     */
//    public CelsiusScale(Model model) {
//        this.model = model;
//    }

    /**
     * retrieves temperature for appropriate scale
     * 
     * @param temp is a ITemperature object
     * @return the temperature value
     */
    protected double getTemperature(Temperature temp) {
        return temp.getCelsius();
    }

    /**
     * Creates an average temperature object and sets it in the model
     * 
     * @param pTemperature - a temperature value
     */
    protected void setAverageTemperature(double pTemperature) {
//        model.setAverageTemperature(new Celsius(pTemperature));
    }

    /**
     * Creates a temperature object
     */
    public void createTemperature() {
//        model.add(new Celsius(model.getInputValue()));
    }

    /**
     * Used by the combobox to display the name of the temperature scale
     *
     * @return the name of the temperature scale
     */
    @Override
    public String toString() {
        return "Celsius";
    }
}