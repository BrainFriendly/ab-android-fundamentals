package l12.brainfriendly.persistenceexample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        String FILENAME = "hello_file";
        String content = "hello world!";

        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(content.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream fis = null;
        try {
            fis = openFileInput(FILENAME);
            byte[] buffer = new byte[1000];
            fis.read(buffer);
            String string = new String(buffer, "UTF-8");

            TextView textView = findViewById(R.id.textView);
            textView.setText(string);

            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        method();

    }

    private void method() {
        BufferedReader reader = null;
        StringBuffer sb = new StringBuffer();
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("autos.json"), "UTF-8"));
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                sb.append(mLine);
            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }
        String autosJson = sb.toString();

        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Auto>>(){}.getType();
        List<Auto> autos = new Gson().fromJson(autosJson, listType);
        Log.e("Pablo", autosJson);
    }
}
