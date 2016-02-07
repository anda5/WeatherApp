package com.anda.weatherapp;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

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
       }

       @Override
       protected Weather doInBackground(String... params) {
           String data = Util.getJSONObject(getApplicationContext(),params[0]);
           weather = JSONParser.getWeather(data);
           Log.v("Data: ",weather._place.get_city() );



           return weather;
       }
   }

}
