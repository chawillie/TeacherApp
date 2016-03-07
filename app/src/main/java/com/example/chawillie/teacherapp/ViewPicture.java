package com.example.chawillie.teacherapp;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by chawillie on 8/6/15.
 */
public class ViewPicture extends Activity {
    ImageView img1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpicture);
        Bundle bundle;
        bundle = getIntent().getExtras();
        String path = bundle.getString("picturepath");

        img1 = (ImageView)findViewById(R.id.imgbig);
        img1.setImageBitmap(BitmapFactory.decodeFile(path));

    }
}
