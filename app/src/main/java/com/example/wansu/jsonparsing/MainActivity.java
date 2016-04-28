package com.example.wansu.jsonparsing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity
{
    public static final String JSON_STRING="{\"employee\":{\"name\":\"Sachin\", \"course\":\"Computer Science\", \"ipk\":3.94}}";
    Button Button1;
    TextView Out;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button1 = (Button) findViewById(R.id.button);
        Out = (TextView)findViewById(R.id.json);

        try
        {
            JSONObject stu = (new JSONObject(JSON_STRING)).getJSONObject("employee");
            String name = stu.getString("name");
            String course = stu.getString("course");
            int ipk = stu.getInt("ipk");

            String str = "\n\n Student" + "\n Name : " + name + "\n Course : " + course + "\n IPK : " + ipk;
            Out.setText(str);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        Button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}