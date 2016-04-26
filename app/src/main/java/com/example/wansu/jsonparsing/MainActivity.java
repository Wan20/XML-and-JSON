package com.example.wansu.jsonparsing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button Button1;
    TextView Out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button1 = (Button) findViewById(R.id.button);
        Out = (TextView) findViewById(R.id.json);

        String strJson="{ \"Student\" :" +
                "[" +
                "{\"id\":\"01\",\"name\":\"Aimbamino\",\"course\":\"Computer Science\",\"ipk\":\"3.9\"}," +
                "{\"id\":\"02\",\"name\":\"Vimal Jaiswal\",\"course\":\"Computer Engineer\",\"ipk\":\"3.94\"}" +
                "] }";

        String data = "";
        try {
            // Create the root JSONObject from the JSON string.
            JSONObject  jsonRootObject = new JSONObject(strJson);

            //Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = jsonRootObject.optJSONArray("Student");

            //Iterate the jsonArray and print the info of JSONObjects
            for(int i=0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                int id = Integer.parseInt(jsonObject.optString("id").toString());
                String name = jsonObject.optString("name").toString();
                String course = jsonObject.optString("course").toString();
                float ipk = Float.parseFloat(jsonObject.optString("ipk").toString());

                data += " \n\n Id= "+ id +" \n Name= "+ name +" \n Course= "+ course + "\n IPK= "+ ipk +" \n ";
            }
            Out.setText(data);
        } catch (JSONException e) {e.printStackTrace();}

        Button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}



