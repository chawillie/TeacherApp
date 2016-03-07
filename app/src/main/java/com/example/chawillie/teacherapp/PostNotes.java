package com.example.chawillie.teacherapp;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by chawillie on 8/5/15.
 */
public class PostNotes extends Activity implements View.OnClickListener {

    EditText subjectName;
    EditText date;
    EditText review;
    private int mYear;
    private int mMonth;
    private int mDay;
    SQL sql;
    Button post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postnotes);

        subjectName = (EditText)findViewById(R.id.reviewname);
        date = (EditText)findViewById(R.id.datereivew);
        review = (EditText)findViewById(R.id.review);
        post= (Button)findViewById(R.id.rpost);

        sql = new SQL(this);

        review.setFilters(new InputFilter[]{new InputFilter.LengthFilter(100)});
date.setOnClickListener(this);
 post.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(v == date)
        {   final Calendar c = Calendar.getInstance();
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

        if(v == post)
        {
            if(subjectName.getText().equals(" ") || date.getText().equals(" ") || review.getText().equals(" "))
            {
                Toast.makeText(PostNotes.this, "Cannot post review, Please note all fields must be filled", Toast.LENGTH_LONG).show();
            }
            else {
                sql.insertReviewData(date.getText().toString(), subjectName.getText().toString(), review.getText().toString());
                date.setText("");
                subjectName.setText("");
                review.setText("");

                Toast.makeText(PostNotes.this, "Review has been Posted", Toast.LENGTH_LONG).show();
            }
        }

    }
}
