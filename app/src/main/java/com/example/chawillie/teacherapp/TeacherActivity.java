package com.example.chawillie.teacherapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by chawillie on 7/27/15.
 */
public class TeacherActivity extends Activity {

   ImageButton img;
    ImageButton img2;
    ImageButton img3;
    ImageButton img4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacherarea);

        img = (ImageButton)findViewById(R.id.imageButton);
        img2 = (ImageButton)findViewById(R.id.imageButton2);
        img3 = (ImageButton)findViewById(R.id.worktodo);
        img4 = (ImageButton)findViewById(R.id.img4);

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getBaseContext(),PostInfo.class);
                startActivity(intent);

            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getBaseContext(),Calender.class);
                startActivity(intent);

            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),Assessment.class);
                startActivity(intent);
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AddStudent.class);
                startActivity(intent);
            }
        });

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

    public void onBackPressed() {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }


}
