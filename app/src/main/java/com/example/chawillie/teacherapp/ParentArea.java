package com.example.chawillie.teacherapp;

/**
 * Created by chawillie on 8/6/15.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by chawillie on 8/6/15.
 */
public class ParentArea extends Activity {
    String[] arr = {"View Class Review","View Progress"};
    String code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parentarea);
        Bundle bundle = getIntent().getExtras();
 code = bundle.getString("code");
        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);

        ListView list = (ListView) findViewById(R.id.listView6);
        list.setAdapter(myAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                final String item = (String) parent.getItemAtPosition(position);

                if(item.equals("View Class Review"))
                {
                    Intent intent = new Intent(getBaseContext(),ViewReview.class);
                    startActivity(intent);
                }
                if(item.equals("View Progress"))
                {
                    
                    Intent intent = new Intent(getBaseContext(),ViewProgress.class);
                    intent.putExtra("code",code);
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