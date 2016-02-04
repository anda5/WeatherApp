package Utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.anda.weatherapp.R;

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

    private static final String _URL = "api.openweathermap.org/data/2.5/weather?q=";
    private static final String _HEADER = "x-api-key";
    private static final String _ICON = "api.openweathermap.org/img/w/";

    private static String getApiKey(Context context){
        String result = null;
        try {
            Resources res = context.getResources();
            InputStream inputStream = res.openRawResource(R.raw.api_key_2);
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);
            result = new String(b);
        } catch (Exception e) {
            Log.v("Error","Can't open the file");
        }
      return result;
    }

    public static String getJSONObject(Context context, String location){
        HttpURLConnection connection = null;
        InputStream inputStream = null;

        try {
            connection = (HttpURLConnection)(new URL(_URL+location)).openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();

            StringBuffer stringBuffer = new StringBuffer();
            inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while((line=bufferedReader.readLine())!=null){
             stringBuffer.append(line+"\r\n");
            }
            inputStream.close();
            connection.disconnect();

            return stringBuffer.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }

    }
}
