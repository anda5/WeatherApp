package model;

/**
 * Created by anda on 2/4/2016.
 */
public class Temperature {

    private double _temperature;
    private float _minTemp;
    private float _maxTemp;

    public double get_temperature() {
        return _temperature;
    }

    public void set_temperature(double _temperature) {
        this._temperature = _temperature;
    }

    public float get_minTemp() {
        return _minTemp;
    }

    public void set_minTemp(float _minTemp) {
        this._minTemp = _minTemp;
    }

    public float get_maxTemp() {
        return _maxTemp;
    }

    public void set_maxTemp(float _maxTemp) {
        this._maxTemp = _maxTemp;
    }
}
