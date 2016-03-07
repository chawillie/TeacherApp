package com.example.chawillie.teacherapp;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by chawillie on 8/6/15.
 */
public class AddStudent extends Activity implements View.OnClickListener {
    EditText name;
    EditText age;
    EditText classn;
    EditText code;
    Button add;
SQL sql;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addstudent);
sql = new SQL(this);
name = (EditText)findViewById(R.id.addname);
        age = (EditText)findViewById(R.id.age);
        classn = (EditText)findViewById(R.id.addclass);
        code = (EditText)findViewById(R.id.code);
        add = (Button)findViewById(R.id.addstu);

        add.setOnClickListener(this);
       ;
    }

    @Override
    public void onClick (View v){
if(v == add)
{
    String stud1 = code.getText().toString();
    String stud2 = age.getText().toString();
    String stud3 = classn.getText().toString();
    String stud4 = name.getText().toString();
    if(!stud1.equals("") || !stud2.equals("") || !stud3.equals("") || !stud4.equals("")) {
        String text = code.getText().toString();
        int number = Integer.parseInt(text);
        String text1 = age.getText().toString();
        int number1 = Integer.parseInt(text1);
        Cursor cur = sql.Codecheck(number);
        if (cur.getCount() > 0) {
            Toast.makeText(AddStudent.this, "A record with the same code exists", Toast.LENGTH_LONG).show();
        } else {
           boolean test = sql.studentData(number,stud4, number1,stud3);
            if(test) {
                Toast.makeText(AddStudent.this, "Student was added successfully", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(AddStudent.this, "Problem adding record", Toast.LENGTH_LONG).show();
            }
        }
    }
    else
    {
        Toast.makeText(AddStudent.this, "All fields must have data", Toast.LENGTH_LONG).show();
    }
}
    }
}