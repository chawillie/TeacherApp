package com.example.chawillie.teacherapp;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by chawillie on 8/6/15.
 */
public class ViewReview extends Activity {
    TextView head;
    TextView date;
    TextView review;
    SQL sql;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewnotes);

        sql = new SQL(this);
        head = (TextView)findViewById(R.id.heading);
        date = (TextView)findViewById(R.id.date);
        review = (TextView)findViewById(R.id.review);

       Cursor curse =  sql.Displayreview();

        if(curse.getCount() == 0)
        {
            return;
        }
        while(curse.moveToNext())
        {
           date.setText(curse.getString(1));
            head.setText(curse.getString(2));
            review.setText(curse.getString(3));
        }
       // Bundle bundle;
       // bundle = getIntent().getExtras();
      //  String path = bundle.getString("picturepath");



        //img1 = (ImageView)findViewById(R.id.imgbig);
        //img1.setImageBitmap(BitmapFactory.decodeFile(path));

    }
}
