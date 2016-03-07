package com.example.chawillie.teacherapp;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.AccessibleObject;

/**
 * Created by chawillie on 8/6/15.
 */
public class ViewProgress extends Activity {
    TextView test1;
    TextView test2;
    TextView test3;
    TextView test4;
    TextView test5;
    TextView test6;
    TextView test7;
    TextView test8;
    TextView test9;
    TextView test10;
    String assess1;
    String assess2;
    String assess3;
    String assess4;
    String status1;
    String status2;
    String status3;
    String status4;
    String codenum;
    int number;
    SQL sql;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdetails);
Bundle bundle = getIntent().getExtras();
        codenum = bundle.getString("code");
        test1 = (TextView)findViewById(R.id.task1);
        test2 = (TextView)findViewById(R.id.task2);
        test3 = (TextView)findViewById(R.id.task4);
        test4 = (TextView)findViewById(R.id.task5);

        test5 = (TextView)findViewById(R.id.status1);
        test6 = (TextView)findViewById(R.id.status2);
        test7 = (TextView)findViewById(R.id.status3);
        test8 = (TextView)findViewById(R.id.status4);
        test9 = (TextView)findViewById(R.id.studcode);
        test10 = (TextView)findViewById(R.id.studname);

        sql = new SQL(this);
        test9.setText(codenum);
        Cursor cur = sql.Displayparentinfo();
        if(cur.getCount() == 0)
        {
            Toast.makeText(ViewProgress.this, "No data", Toast.LENGTH_LONG).show();
        }
        else
        {
            while(cur.moveToNext())
            {
              number =   cur.getInt(0);
                assess1 = cur.getString(1);
                assess2 = cur.getString(2);
                assess3 = cur.getString(3);
                assess4 = cur.getString(4);
                status1 = cur.getString(5);
                status2 = cur.getString(6);
                status3 = cur.getString(7);
                status4 = cur.getString(8);
             test1.setText(assess1);
                test2.setText(assess2);
                test3.setText(assess3);
                test4.setText(assess4);
                test5.setText(status1);
                test6.setText(status2);
                test7.setText(status3);
                test8.setText(status4);


            }
           sql.studName(number);
            while (cur.moveToNext())
            {
                test10.setText(cur.getString(0));
            }


        }


    }
}
