package errors;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2015/6/4.
 */
public class JSONFileReader {
  public static String getJSON(Context context, String fileName) {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      AssetManager assetManager = context.getAssets();
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(fileName)));
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        stringBuilder.append(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return stringBuilder.toString();
  }
}
