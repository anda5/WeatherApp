package com.anda.weatherapp;

import android.graphics.drawable.Icon;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.net.URL;

import Data.JSONParser;
import Utils.Util;
import model.Weather;


public class MainActivity extends ActionBarActivity {

    private TextView cityName;
    private TextView temp;
    private ImageView icon;
    private TextView description;
    private TextView humidity;
    private TextView pressure;
    private TextView wind;
    private TextView sunrise;
    private TextView sunset;
    private TextView updated;
    Weather weather = new Weather();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityName = (TextView)findViewById(R.id.city);
        temp= (TextView)findViewById(R.id.temperature);
        icon=(ImageView)findViewById(R.id.icon);
        description= (TextView)findViewById(R.id.cloud);
        humidity= (TextView)findViewById(R.id.humidity);
        pressure= (TextView)findViewById(R.id.pressure);
        wind= (TextView)findViewById(R.id.wind);
        sunrise= (TextView)findViewById(R.id.sunrise);
        sunset = (TextView)findViewById(R.id.sunset);
        //updated = (TextView)findViewById(R.id.city);
        renderWeatherData("Galati");

      //  Log.v("Data: ",weather._place.get_city() );
    }

    public void renderWeatherData(String city){
     WeatherTask weatherTask = new WeatherTask();
     weatherTask.execute(new String[]{city});
    }


   private class WeatherTask extends AsyncTask<String,Void, Weather>{

       @Override
       protected void onPostExecute(Weather weather) {
           super.onPostExecute(weather);
           cityName.setText(weather._place.get_city() + "," + weather._place.get_country());
           temp.setText(weather._condition.get_temperature()+"");
           wind.setText(weather._wind.get_degree()+","+weather._wind.get_speed());
           description.setText(""+weather._cloud.get_precipitation());
           pressure.setText( ""+weather._condition.get_pressure());
           humidity.setText(""+ weather._condition.get_humidity());
           sunrise.setText(""+ weather._place.get_sunrise());
           sunset.setText(""+weather._place.get_sunset());



           String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
           String IMG_URL = "http://openweathermap.org/img/w/";


       }

       @Override
       protected Weather doInBackground(String... params) {
           String data = Util.getJSONObject(getApplicationContext(),params[0]);
           weather = JSONParser.getWeather(data);
           Log.v("Data: ",weather._place.get_city() );
           Log.v("Data: ", String.valueOf(weather._condition.get_temperature()));


           return weather;
       }
   }

}
