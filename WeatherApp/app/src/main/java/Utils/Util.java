package Utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.anda.weatherapp.R;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by anda on 2/4/2016.
 */
public class Util {

    private static final String URL = "api.openweathermap.org/data/2.5/weather?q=";
    private static final String HEADER = "x-api-key";

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
}
