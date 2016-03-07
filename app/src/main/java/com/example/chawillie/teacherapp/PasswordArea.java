package com.example.chawillie.teacherapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by chawillie on 8/6/15.
 */
public class PasswordArea extends Activity {
    EditText text1;
    SQL sql;
    int number;
    Button button;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password);
        sql = new SQL(this);

        text1 = (EditText)findViewById(R.id.passwordpar);
button = (Button)findViewById(R.id.button4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String test = text1.getText().toString();
                // int number = Integer.parseInt(studentcode);
                number = Integer.parseInt(test);

                Cursor curse = sql.Codecheck(number);

                if(curse.getCount() == 0)
                {
                    Toast.makeText(PasswordArea.this, "Please try again code incorrect", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Intent intent = new Intent(getBaseContext(),ParentArea.class);
                    intent.putExtra("code",text1.getText().toString());
                    startActivity(intent);
                }

            }
        });


    }
}
