package com.example.chawillie.teacherapp;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chawillie on 7/28/15.
 */
public class Calender extends Activity {

Button cale;
    ListView list;
   Lists adapter;
    SQL data;
   // static int position =0;
    ArrayList<Row> Arry = new ArrayList<Row>();
String[] stringarr ={};
 String[] stringarr2 ={};
    //String[] name2;

    Context context = Calender.this;



    ArrayList<String> stringArrayList = new ArrayList<String>();

    ArrayList<String> stringArrayList2 = new ArrayList<String>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       setContentView(R.layout.list);

        list = (ListView) findViewById(R.id.listView2);
     Bundle bundle = getIntent().getExtras();
//        boolean check = bundle.getBoolean("isset", false);
//Doprocessing();


       //Intent compare = getIntent();

        if(bundle != null) {

            boolean check = bundle.getBoolean("isset");
            if (check) {

                Doprocessing();

                getDataInList();
                list.setAdapter(new Lists(context, Arry));
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                            int pos = position + 1;
getDetails(pos);
                    }
                });
            }
        }
        else {



            // insert data into the list before setting the adapter
            // otherwise it will generate NullPointerException  - Obviously
            Doprocessing();
            getDataInList();
            list.setAdapter(new Lists(context, Arry));
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                int posit = position + 1;


getDetails(posit);
                                            }
                                        }

            );

                                        }

                    cale = (Button) findViewById(R.id.button3);
        cale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Schedule.class);
                startActivity(intent);

            }
        });






    }

    private void getDataInList() {
        for (int i = 0; i < stringarr.length; i++) {
            // Create a new object for each list item
            Row ld = new Row();
            ld.setTitle(stringarr[i]);
           ld.setDescription(stringarr2[i]);
            //ld.setImgResId(img[i]);
            // Add this object into the ArrayList myList
            Arry.add(ld);
        }
    }

public void getDetails(int pos)
{
    try{
        data = new SQL(this);
        Intent intent = new Intent(getBaseContext(),TaskDetails.class);
        Cursor res = data.DisplayDetails(pos);
        if(res.getCount() == 0)
        {
            return;
        }
        while(res.moveToNext())
        {

            //intent.putExtra("isset",isset);
            intent.putExtra("eventid",res.getString(0));
            intent.putExtra("EventName",res.getString(1));
            intent.putExtra("EventTime",res.getString(4));
            intent.putExtra("EventDate",res.getString(3));
            intent.putExtra("ClassName",res.getString(2));
            intent.putExtra("ScheduleTime",res.getString(7));
            intent.putExtra("ScheduleDate",res.getString(6));
            intent.putExtra("Description", res.getString(5));
            //intent.putExtra("date",date.getText().toString());


        }
        startActivity(intent);
    }catch(Exception e)
    {
        Toast toast = Toast.makeText(this, "error retrieving data", Toast.LENGTH_SHORT);
        toast.show();
    }

}
      public void onBackPressed() {
        Intent intent = new Intent(getBaseContext(), TeacherActivity.class);
        startActivity(intent);
    }

    public void Doprocessing()
    {
        try {


            data = new SQL(this);
            Cursor res = data.getEventinfo();
            if (res.getCount() == 0) {
                return;
            }
//StringBuffer buffer = new StringBuffer();

            while (res.moveToNext()) {
                stringArrayList.add(res.getString(0));
                stringArrayList2.add(res.getString(1));

                stringarr = stringArrayList.toArray(new String[stringArrayList.size()]);
                stringarr2 = stringArrayList2.toArray(new String[stringArrayList2.size()]);

            }
        } catch(Exception e) {
            Toast toast = Toast.makeText(this, "error creating list", Toast.LENGTH_SHORT);
            toast.show();
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
