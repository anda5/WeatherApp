package model;

/**
 * Created by anda on 2/4/2016.
 */
public class Condition {

    private int _id;
    private String _condition;
    private String _description;
    private String _icon;
    private float _pressure;
    private float _humidity;
    private float _maxTemp;
    private float _minTemp;
    private double _temperature;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_condition() {
        return _condition;
    }

    public void set_condition(String _condition) {
        this._condition = _condition;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public String get_icon() {
        return _icon;
    }

    public void set_icon(String _icon) {
        this._icon = _icon;
    }

    public float get_pressure() {
        return _pressure;
    }

    public void set_pressure(float _pressure) {
        this._pressure = _pressure;
    }

    public float get_humidity() {
        return _humidity;
    }

    public void set_humidity(float _humidity) {
        this._humidity = _humidity;
    }

    public float get_maxTemp() {
        return _maxTemp;
    }

    public void set_maxTemp(float _maxTemp) {
        this._maxTemp = _maxTemp;
    }

    public float get_minTemp() {
        return _minTemp;
    }

    public void set_minTemp(float _minTemp) {
        this._minTemp = _minTemp;
    }

    public double get_temperature() {
        return _temperature;
    }

    public void set_temperature(double _temperature) {
        this._temperature = _temperature;
    }
}
