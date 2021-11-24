package scale;

import temperature.Temperature;

/**
 *
 * @author Mr Thompson
 */
public class KelvinScale  extends AbstractTemperatureScale {
    /**
     * Constructor for Abstract temperature scale
     *
     * @param model is the data model for the application
     */
//    public KelvinScale(Model model) {
//        this.model = model;
//    }

    /**
     * retrieves temperature for appropriate scale
     *
     * @param temp is a ITemperature object
     * @return the temperature value
     */
    protected double getTemperature(Temperature temp) {
        return temp.getKelvin();
    }

    /**
     * Creates an average temperature object and sets it in the model
     *
     * @param pTemperature - a temperature value
     */
    protected void setAverageTemperature(double pTemperature) {
//        model.setAverageTemperature(new Kelvin(pTemperature));
    }

    /**
     * Creates a temperature object
     */
    public void createTemperature() {
//        model.add(new Kelvin(model.getInputValue()));
    }

    /**
     * Used by the combobox to display the name of the temperature scale
     *
     * @return the name of the temperature scale
     */
    @Override
    public String toString() {
        return "Kelvin";
    }
}
