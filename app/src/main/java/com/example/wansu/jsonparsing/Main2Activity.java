package com.example.wansu.jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main2Activity extends AppCompatActivity {
    TextView Out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Out = (TextView) findViewById(R.id.json);

        String strJson=
                "{ \"Student\" :[" +
                "{\"id\":\"01\", \"name\":\"Aimbamino\", \"course\":\"Computer Science\", \"ipk\":\"3.9\"}," +
                "{\"id\":\"02\", \"name\":\"Vimal Jaiswal\", \"course\":\"Computer Engineer\", \"ipk\":\"3.94\"}," +
                        "{\"id\":\"03\", \"name\":\"Jimmie\", \"course\":\"Computer Science\", \"ipk\":\"3.25\"}," +
                        "{\"id\":\"04\", \"name\":\"Kuma1\", \"course\":\"Computer Engineer\", \"ipk\":\"3.954\"}," +
                        "{\"id\":\"05\", \"name\":\"Tabitha\", \"course\":\"Computer Science\", \"ipk\":\"3.96\"}," +
                        "{\"id\":\"06\", \"name\":\"Natasha\", \"course\":\"Computer Engineer\", \"ipk\":\"3.8\"}" +
                "] }";

        String data = "";
        try
        {
            // Create the root JSONObject from the JSON string.
            JSONObject jsonRootObject = new JSONObject(strJson);

            //Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = jsonRootObject.optJSONArray("Student");

            //Iterate the jsonArray and print the info of JSONObjects
            for(int i=0; i < jsonArray.length(); i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                int id = Integer.parseInt(jsonObject.optString("id").toString());
                String name = jsonObject.optString("name").toString();
                String course = jsonObject.optString("course").toString();
                float ipk = Float.parseFloat(jsonObject.optString("ipk").toString());

                data += " Id = "+ id +" \n Name = "+ name +" \n Course = "+ course + "\n IPK = "+ ipk +" \n\n";
            }
            Out.setText(data);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
}
