package com.example.chawillie.teacherapp;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by chawillie on 8/6/15.
 */

public class ShowDetails extends Activity {
TextView test1;
   TextView test2;
    TextView test3;
    TextView test4;
    TextView test5;
    TextView test6;
    TextView test7;
    TextView test8;
    TextView test9;
   TextView test10;
    String assess1;
    String assess2;
    String assess3;
    String assess4;
    String status1;
    String status2;
    String status3;
    String status4;
    int number;


    SQL sql;
    Button share;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdetails);
        Bundle bundle = getIntent().getExtras();
        test1 = (TextView)findViewById(R.id.task1);
        test2 = (TextView)findViewById(R.id.task2);
        test3 = (TextView)findViewById(R.id.task4);
        test4 = (TextView)findViewById(R.id.task5);

        test5 = (TextView)findViewById(R.id.status1);
        test6 = (TextView)findViewById(R.id.status2);
        test7 = (TextView)findViewById(R.id.status3);
        test8 = (TextView)findViewById(R.id.status4);
        test9 = (TextView)findViewById(R.id.studcode);
        test10 = (TextView)findViewById(R.id.studname);
        sql = new SQL(this);


        assess1 =  bundle.getString("assess1");
        assess2 =  bundle.getString("assess2");
        assess3 = bundle.getString("assess3");
        assess4 =  bundle.getString("assess4");
       String studentcode =  bundle.getString("studentcode");
        status1 =  bundle.getString("status5");
        status2 = bundle.getString("status6");
         status3 = bundle.getString("status7");
        status4 =  bundle.getString("status8");

       // String text = studentcode.toString();
         number = Integer.parseInt(studentcode);

test1.setText(assess1);
        test2.setText(assess2);
        test3.setText(assess3);
        test4.setText(assess4);
        test5.setText(status1);
        test6.setText(status2);
        test7.setText(status3);
        test8.setText(status4);
        //test6.setText(status5);
Cursor cur = sql.studName(number);
        while (cur.moveToNext())
        {
            test10.setText(cur.getString(0));
        }

test9.setText(studentcode);


       /* intent.putExtra("assess1", spin1.getSelectedItem().toString());
        intent.putExtra("assess2", spin2.getSelectedItem().toString());
        intent.putExtra("assess3", spin3.getSelectedItem().toString());
        intent.putExtra("assess4", spin4.getSelectedItem().toString());
        intent.putExtra("studentcode",code.getText().toString());
        intent.putExtra("status5", spin5.getSelectedItem().toString());
        intent.putExtra("status6", spin6.getSelectedItem().toString());
        intent.putExtra("status7", spin7.getSelectedItem().toString());
        intent.putExtra("status8", spin8.getSelectedItem().toString());*/
/*share.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        boolean check = sql.insertparentview(number,assess1,assess2,assess3,assess4,status1,status2,status3,status4);
        if(check)
        {
            Toast.makeText(ShowDetails.this, "Data has been shared with parent", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(ShowDetails.this, "Error has occured while sharing", Toast.LENGTH_LONG).show();
        }
    }
});*/
    }
}
