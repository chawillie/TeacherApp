package com.example.chawillie.teacherapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by chawillie on 8/4/15.
 */


public class PostInfo extends Activity {
    String[] arr = {"Post-Notes","Post-Examples"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postnoteschoice);

        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);

        ListView list = (ListView) findViewById(R.id.listView3);
        list.setAdapter(myAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                final String item = (String) parent.getItemAtPosition(position);

                if(item.equals("Post-Notes"))
                {
                    Intent intent = new Intent(getBaseContext(),PostNotes.class);
                    startActivity(intent);
                }
                if(item.equals("Post-Examples"))
                {
                    Intent intent = new Intent(getBaseContext(),PostExamples.class);
                    startActivity(intent);
                }


            }
        });




    }

}
