package com.example.chawillie.teacherapp;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by chawillie on 7/29/15.
 */
public class Schedule extends Activity implements View.OnClickListener {


    EditText time;
    EditText date;
    EditText stime;
    EditText sdate;
    EditText eventname;
    EditText classname;
    EditText desc;
    private int mMinute;
    private int mHour;
    private int mYear;
    private int mMonth;
    private int mDay;
    private int mMinute1;
    private int mHour1;
    private int mYear1;
    private int mMonth1;
    private int mDay1;
    Button cancel;
    Button save;
    SQL  data;
boolean checkedit = false;
String index;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_calender);
        cancel = (Button) findViewById(R.id.button);
        save = (Button) findViewById(R.id.button2);

time = (EditText) findViewById(R.id.editText3);
        date = (EditText)findViewById(R.id.editText7);
stime = (EditText) findViewById(R.id.editText6);
        sdate = (EditText) findViewById(R.id.editText5);
        eventname = (EditText) findViewById(R.id.editText);
        classname = (EditText) findViewById(R.id.editText2);
        desc = (EditText)findViewById(R.id.editText4);

        time.setOnClickListener(this);
        date.setOnClickListener(this);
        stime.setOnClickListener(this);
        sdate.setOnClickListener(this);
        cancel.setOnClickListener(this);
        save.setOnClickListener(this);

       desc.setFilters(new InputFilter[]{new InputFilter.LengthFilter(100)});

   data   = new SQL(this);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null)
        {
             checkedit = bundle.getBoolean("pass",false);
            if(checkedit)
            {
                time.setText(bundle.getString("EventTime1"));
                date.setText(bundle.getString("EventDate1"));
                stime.setText(bundle.getString("ScheduleTime1"));
                sdate.setText(bundle.getString("ScheduleDate1"));
                eventname.setText(bundle.getString("EventName1"));
                classname.setText(bundle.getString("ClassName1"));
                desc.setText(bundle.getString("Description1"));
                index = bundle.getString("count");

            }
            /*intent.putExtra("EventDate1",text1.getText().toString());
            intent.putExtra("EventTime1",text2.getText().toString());
            intent.putExtra("EventName1",text3.getText().toString());
            intent.putExtra("C1assName1",text4.getText().toString());
            intent.putExtra("ScheduleTime1",text5.getText().toString());
            intent.putExtra("ScheduleDate1",text6.getText().toString());
            intent.putExtra("Description1",text7.getText().toString());
            intent.putExtra("pass",true);*/
        }

    }

    public void onClick(View v)
    {
        if(v == time) {
            // http://pulse7.net/android/date-picker-dialog-time-picker-dialog-android/
            // Process to get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            //Launch Dialog
            TimePickerDialog tpd = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            // Display Selected time in textbox
                            time.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            tpd.show();
        }

        if(v == date) {
            // http://pulse7.net/android/date-picker-dialog-time-picker-dialog-android/
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dpd = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            date.setText(dayOfMonth + "-"
                                    + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            dpd.show();

        }

        if(v == stime)
        {
            // http://pulse7.net/android/date-picker-dialog-time-picker-dialog-android/
            final Calendar c = Calendar.getInstance();
            mHour1 = c.get(Calendar.HOUR_OF_DAY);
            mMinute1 = c.get(Calendar.MINUTE);

            //Launch Dialog
            TimePickerDialog tpd = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            // Display Selected time in textbox
                            stime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour1, mMinute1, false);
            tpd.show();
        }

        if(v == sdate)
        {
            // http://pulse7.net/android/date-picker-dialog-time-picker-dialog-android/
            final Calendar c = Calendar.getInstance();
            mYear1 = c.get(Calendar.YEAR);
            mMonth1 = c.get(Calendar.MONTH);
            mDay1 = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dpd = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            sdate.setText(dayOfMonth + "-"
                                    + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear1, mMonth1, mDay1);
            dpd.show();
        }

        if(v == cancel)
        {
            Intent intent = new Intent(getBaseContext(),Calender.class);
                    startActivity(intent);
        }

        if(v == save) {
            if (TextUtils.isEmpty(eventname.getText())) {

                Toast.makeText(Schedule.this, "Cannot create event without an Event Name", Toast.LENGTH_LONG).show();
            } else {

if(checkedit)
{
boolean dido = data.Update(index,eventname.getText().toString(), classname.getText().toString(), date.getText().toString(), time.getText().toString(), desc.getText().toString(), sdate.getText().toString(), stime.getText().toString());
if(dido)
{
    Toast.makeText(Schedule.this, "Edit Complete", Toast.LENGTH_LONG).show();
    Intent intent = new Intent(getBaseContext(), Calender.class);
    startActivity(intent);
    //intent.putExtra("evename",eventname.getText().toString());
    // intent.putExtra("clname",classname.getText().toString());
    //intent.putExtra("date",date.getText().toString());

}
}
                else {
    boolean isset = data.insertData(eventname.getText().toString(), classname.getText().toString(), date.getText().toString(), time.getText().toString(), desc.getText().toString(), sdate.getText().toString(), stime.getText().toString());
    if (isset) {
        Toast.makeText(Schedule.this, "Event has been saved", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getBaseContext(), Calender.class);
        intent.putExtra("isset", isset);
        //intent.putExtra("evename",eventname.getText().toString());
        // intent.putExtra("clname",classname.getText().toString());
        //intent.putExtra("date",date.getText().toString());
        startActivity(intent);

    } else {
        Toast.makeText(Schedule.this, "Event has not been saved, please try again", Toast.LENGTH_LONG).show();
    }
}
            }
        }
    }

    /*public void onBackPressed() {
        Intent intent = new Intent(getBaseContext(), TeacherActivity.class);
        startActivity(intent);
    }*/
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
