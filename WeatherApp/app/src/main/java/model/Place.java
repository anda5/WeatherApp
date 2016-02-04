package model;

/**
 * Created by anda on 2/4/2016.
 */
public class Place {

    private double _latitude;
    private double _longitude;
    private long _sunset;
    private long _sunrise;
    private String _country;
    private String _city;
    private long _lastUpdate;

    public double get_latitude() {
        return _latitude;
    }

    public void set_latitude(double _latitude) {
        this._latitude = _latitude;
    }

    public double get_longitude() {
        return _longitude;
    }

    public void set_longitude(double _longitude) {
        this._longitude = _longitude;
    }

    public long get_sunset() {
        return _sunset;
    }

    public void set_sunset(long _sunset) {
        this._sunset = _sunset;
    }

    public long get_sunrise() {
        return _sunrise;
    }

    public void set_sunrise(long _sunrise) {
        this._sunrise = _sunrise;
    }

    public String get_country() {
        return _country;
    }

    public void set_country(String _country) {
        this._country = _country;
    }

    public String get_city() {
        return _city;
    }

    public void set_city(String _city) {
        this._city = _city;
    }

    public long get_lastUpdate() {
        return _lastUpdate;
    }

    public void set_lastUpdate(long _lastUpdate) {
        this._lastUpdate = _lastUpdate;
    }
}
