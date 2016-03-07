package com.example.chawillie.teacherapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chawillie on 8/6/15.
 */
public class AssessPage extends Activity {
    Spinner spin1;
    Spinner spin2;
    Spinner spin3;
    Spinner spin4;
    Spinner spin5;
    Spinner spin6;
    Spinner spin7;
    Spinner spin8;
    int grade1;
    int grade2;
    int grade3;
    int grade4;
    List list = new ArrayList();
    List list1 = new ArrayList();
    List list2 = new ArrayList();
    List list3 = new ArrayList();
    List list4 = new ArrayList();
    EditText code;
Button button1;
    Button button2;
    SQL sql;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accesspage);

        spin1 = (Spinner)findViewById(R.id.spinner);
        spin2 = (Spinner)findViewById(R.id.spinner2);
        spin3 = (Spinner)findViewById(R.id.spinner3);
        spin4 = (Spinner)findViewById(R.id.spinner4);
        spin5 = (Spinner)findViewById(R.id.spinner5);
        spin6 = (Spinner)findViewById(R.id.spinner6);
        spin7 = (Spinner)findViewById(R.id.spinner7);
        spin8 = (Spinner)findViewById(R.id.spinner8);
        button1 = (Button)findViewById(R.id.next2);
        button2 = (Button)findViewById(R.id.back);
        code = (EditText)findViewById(R.id.accesscode);
        sql = new SQL(this);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
           /* intent.putExtra("homework", number);
            intent.putExtra("classexercise",number1);
            intent.putExtra("project", number2);
            intent.putExtra("assignment",number3);*/

          grade1=  bundle.getInt("homework");
            grade2 = bundle.getInt("classexercise");
            grade3 = bundle.getInt("project");
          grade4 =   bundle.getInt("assignment");

        }
        else {

            Toast.makeText(AssessPage.this, "Please go back and re-enter", Toast.LENGTH_LONG).show();
        }
        if(grade1 != 0) {
            for (int x = 1; x <= grade1; x++) {


                String testString = Integer.toString(x);
                String homework = "Homework" + testString;


                list.add(homework);
            }
        }
        if(grade2 != 0) {
            for (int x = 1; x <= grade2; x++) {


                String testString = Integer.toString(x);
                String homework = "Class Test" + testString;


                list1.add(homework);
            }
        }
        if(grade3 != 0) {
            for (int x = 1; x <= grade3; x++) {


                String testString = Integer.toString(x);
                String homework = "Project" + testString;


                list2.add(homework);
            }
        }
        if(grade4 != 0) {
            for (int x = 1; x <= grade4; x++) {


                String testString = Integer.toString(x);
                String homework = "Assignment" + testString;


                list3.add(homework);
            }
        }
        list4.add("Completed");
        list4.add("Still Pending");
        list4.add("Not Completed");
        ArrayAdapter dataadpter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        dataadpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(dataadpter);
        ArrayAdapter dataadpter1 = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list1);
        dataadpter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(dataadpter1);
        ArrayAdapter dataadpter2 = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list2);
        dataadpter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin3.setAdapter(dataadpter2);
        ArrayAdapter dataadpter3 = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list3);
        dataadpter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin4.setAdapter(dataadpter3);
        ArrayAdapter dataadpter4 = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list4);
        dataadpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin5.setAdapter(dataadpter4);
        ArrayAdapter dataadpter5 = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list4);
        dataadpter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin6.setAdapter(dataadpter5);
        ArrayAdapter dataadpter6 = new ArrayAdapter(this, android.R.layout.simple_list_item_1,list4);
        dataadpter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin7.setAdapter(dataadpter6);
        ArrayAdapter dataadpter7 = new ArrayAdapter(this, android.R.layout.simple_list_item_1,list4);
        dataadpter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin8.setAdapter(dataadpter7);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stud1 = code.getText().toString();
                String text = code.getText().toString();
                int number = Integer.parseInt(text);
                Cursor cur = sql.Codecheck(number);
                if (!stud1.equals("")) {
                    if (cur.getCount() == 0) {
                        Toast.makeText(AssessPage.this, "Student code does not exist", Toast.LENGTH_LONG).show();
                    } else {


                        Intent intent = new Intent(getBaseContext(), ShowDetails.class);
                        intent.putExtra("assess1", spin1.getSelectedItem().toString());
                        intent.putExtra("assess2", spin2.getSelectedItem().toString());
                        intent.putExtra("assess3", spin3.getSelectedItem().toString());
                        intent.putExtra("assess4", spin4.getSelectedItem().toString());
                         intent.putExtra("studentcode",code.getText().toString());
                        intent.putExtra("status5", spin5.getSelectedItem().toString());
                        intent.putExtra("status6", spin6.getSelectedItem().toString());
                        intent.putExtra("status7", spin7.getSelectedItem().toString());
                        intent.putExtra("status8", spin8.getSelectedItem().toString());
                        startActivity(intent);
                    }
                } else {

                    Toast.makeText(AssessPage.this, "Must enter student code", Toast.LENGTH_LONG).show();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Assessment.class);
                startActivity(intent);
            }
        });


    }
    }


