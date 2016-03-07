package com.example.chawillie.teacherapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by chawillie on 8/4/15.
 */
public class TaskDetails extends Activity {
    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;
    TextView text5;
    TextView text6;
    TextView text7;
    Button button;
  String pos;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.displaydetails);
        Bundle bundle = getIntent().getExtras();

        text1 = (TextView)findViewById(R.id.detaildate);
        text2 = (TextView)findViewById(R.id.detailtime);
        text3 = (TextView)findViewById(R.id.detaileventname);
        text4 = (TextView)findViewById(R.id.detailclassname);
        text5 = (TextView)findViewById(R.id.detailsd);
        text6 = (TextView)findViewById(R.id.detailst);
        text7 = (TextView)findViewById(R.id.detaildesc);
        button = (Button)findViewById(R.id.edit);
/*
        intent.putExtra("EventName",res.getString(1));
        intent.putExtra("EventTime",res.getString(4));
        intent.putExtra("EventDate",res.getString(3));
        intent.putExtra("ClassName",res.getString(2));
        intent.putExtra("ScheduleTime",res.getString(7));
        intent.putExtra("ScheduleDate",res.getString(6));
        intent.putExtra("Description",res.getString(5));*/

        text1.setText(bundle.getString("EventDate"));
        text2.setText(bundle.getString("EventTime"));
        text3.setText(bundle.getString("EventName"));
        text4.setText(bundle.getString("ClassName"));
        text5.setText(bundle.getString("ScheduleTime"));
        text6.setText(bundle.getString("ScheduleDate"));
        text7.setText(bundle.getString("Description"));
        pos = bundle.getString("eventid");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(),Schedule.class);
                intent.putExtra("EventDate1",text1.getText().toString());
                intent.putExtra("EventTime1",text2.getText().toString());
                intent.putExtra("EventName1",text3.getText().toString());
                intent.putExtra("ClassName1",text4.getText().toString());
                intent.putExtra("ScheduleTime1",text5.getText().toString());
                intent.putExtra("ScheduleDate1",text6.getText().toString());
                intent.putExtra("Description1",text7.getText().toString());
                intent.putExtra("count",pos);
                intent.putExtra("pass",true);
                startActivity(intent);

            }
        });





    }
}
