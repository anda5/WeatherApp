package Utils;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.util.Log;

import com.anda.weatherapp.R;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by anda on 2/4/2016.
 */
public class Util {

    private static final String _URL = "http://api.openweathermap.org/data/2.5/weather?q=Galati,ro&appid=";
    private static final String _HEADER = "x-api-key";
    private static final String _ICON = "api.openweathermap.org/img/w/";

    private static String getApiKey(Context context) {
        String result = null;
        try {
            Resources res = context.getResources();
            InputStream inputStream = res.openRawResource(R.raw.api_key_2);
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);
            result = new String(b);
        } catch (Exception e) {
            Log.v("Error", "Can't open the file");
        }
        return result;
    }

    public static String getJSONObject(Context context, String location) {

        String responseString = null;
        if (((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null) {
            try {
                // Get a HTTP client
                DefaultHttpClient client = new DefaultHttpClient();
                HttpEntity entity = null;
                HttpResponse response = null;

                // Create and execute a new GET HTTP request
                HttpGet httpGet = new HttpGet(_URL);
                // Add API Key in header
                httpGet.addHeader("x-api-key", "4622fe72e39039fa958f8398e55a3c70");
                response = client.execute(httpGet);

                // Get response from server
                entity = response.getEntity();
                responseString = EntityUtils.toString(entity);

            } catch (Exception e) {
                // Log exception and print stack trace
                Log.d("HTTP", e.getMessage().toString());


            }

            // Return response string
        }

        return responseString;
    }


    }


