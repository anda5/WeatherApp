package model;

/**
 * Created by anda on 2/4/2016.
 */
public class Weather {

    public Place _place;
    public String _icon;
    public Condition _condition = new Condition();
    public Temperature _temperature = new Temperature();
    public Snow _snow = new Snow();
    public Cloud _cloud = new Cloud();
    public Wind _wind = new Wind();

}
