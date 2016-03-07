package com.example.chawillie.teacherapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by chawillie on 8/6/15.
 */
public class Assessment extends Activity {

    EditText num1;
    EditText num2;
    EditText num3;
    EditText num4;
    Button cancel;
    Button next;
    int number;
    int number1;
    int number2;
    int number3;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asses);

        num1 = (EditText)findViewById(R.id.homew);
        num2 = (EditText)findViewById(R.id.cexercise);
        num3 = (EditText)findViewById(R.id.project);
        num4 = (EditText)findViewById(R.id.assignment);

        cancel = (Button)findViewById(R.id.asscancel);
        next = (Button)findViewById(R.id.next);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),TeacherActivity.class);
                startActivity(intent);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = num1.getText().toString();
                try {
                    number = Integer.parseInt(text);
                    //Log.i("",num+" is a number");
                } catch (NumberFormatException e) {
                    Log.i("", text + "is not a number");
                }

                String text1 = num2.getText().toString();
                try {
                    number1 = Integer.parseInt(text1);
                    //Log.i("",num+" is a number");
                } catch (NumberFormatException e) {
                    Log.i("", text1 + "is not a number");
                }
                String text2 = num3.getText().toString();
                try {
                    number2 = Integer.parseInt(text2);
                    //Log.i("",num+" is a number");
                } catch (NumberFormatException e) {
                    Log.i("", text2 + "is not a number");
                }
                String text3 = num4.getText().toString();
                try {
                    number3 = Integer.parseInt(text3);
                    //Log.i("",num+" is a number");
                } catch (NumberFormatException e) {
                    Log.i("", text3 + "is not a number");
                }

                if (text.equals("") || text1.equals("") || text2.equals("") || text3.equals("")) {
                    Toast.makeText(Assessment.this, "Must enter data in all fields", Toast.LENGTH_LONG).show();
                }
                else {
                    if (number > 5 || number1 > 5 || number2 > 5 || number3 > 5) {
                        Toast.makeText(Assessment.this, "All fields must be less than 5", Toast.LENGTH_LONG).show();
                    } else {
                        Intent intent = new Intent(getBaseContext(), AssessPage.class);
                        intent.putExtra("homework", number);
                        intent.putExtra("classexercise", number1);
                        intent.putExtra("project", number2);
                        intent.putExtra("assignment", number3);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
