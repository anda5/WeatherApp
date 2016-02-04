package Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Place;
import model.Weather;

/**
 * Created by anda on 2/4/2016.
 */
public class JSONParser {

    public static Weather getWeather(String jsonString){

        Weather weather = new Weather();

        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            Place place = new Place();
            JSONObject coordonetes = jsonObject.getJSONObject("coord");
            JSONObject sys = jsonObject.getJSONObject("sys");
            JSONArray jsonArray = jsonObject.getJSONArray("weather");
            JSONObject weatherObj = jsonArray.getJSONObject(0);
            JSONObject wind = jsonObject.getJSONObject("wind");
            JSONObject cloud = jsonObject.getJSONObject("clouds");

            place.set_latitude(coordonetes.getDouble("lat"));
            place.set_longitude(coordonetes.getDouble("lon"));
            place.set_country(sys.getString("country"));
            place.set_lastUpdate(jsonObject.getLong("dt"));
            place.set_sunrise(sys.getLong("sunrise"));
            place.set_sunset(sys.getLong("sunset"));
            place.set_city(jsonObject.getString("name"));
            weather._place = place;
            weather._condition.set_id(weatherObj.getInt("id"));
            weather._condition.set_condition(weatherObj.getString("main"));
            weather._condition.set_description(weatherObj.getString("description"));
            weather._condition.set_icon(weatherObj.getString("icon"));
            weather._cloud.set_precipitation(cloud.getInt("all"));
            weather._wind.set_speed((float) wind.getDouble("speed"));
            weather._wind.set_degree((float) wind.getDouble("deg"));

            return weather;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

}
