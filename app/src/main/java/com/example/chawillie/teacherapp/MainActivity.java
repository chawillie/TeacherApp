package com.example.chawillie.teacherapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity {

    String[] arr = {"Teacher","Parent","Student"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);

        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(myAdapter);

list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


         final String item = (String) parent.getItemAtPosition(position);

        if(item.equals("Parent"))
        {
            Intent intent = new Intent(getBaseContext(),PasswordArea.class);
            startActivity(intent);
        }
        if(item.equals("Teacher"))
        {
         Intent intent = new Intent(getBaseContext(),TeacherActivity.class);
            startActivity(intent);
        }
        if(item.equals("Student"))
        {
            Intent intent = new Intent(getBaseContext(),StudentArea.class);
            startActivity(intent);
        }

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
}
