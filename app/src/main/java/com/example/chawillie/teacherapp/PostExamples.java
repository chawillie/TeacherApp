package com.example.chawillie.teacherapp;

import android.app.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by chawillie on 8/5/15.
 */

    public class PostExamples extends Activity {


        private static int RESULT_LOAD_IMAGE = 1;
String path;
    SQL sql;

    ImageView imageView;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.postexamples);

           ImageButton buttonLoadImage = (ImageButton) findViewById(R.id.camera);
            final EditText descnotes  = (EditText) findViewById(R.id.notedesc);
            Button cancel = (Button) findViewById(R.id.bc);
            Button post = (Button) findViewById(R.id.bp);
            sql = new SQL(this);
            buttonLoadImage.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {


                    Intent i = new Intent(
                            Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                    startActivityForResult(i, RESULT_LOAD_IMAGE);
                }
            });

            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getBaseContext(),PostInfo.class);
                    startActivity(intent);
                }
            });

            post.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(imageView.getDrawable() == null || descnotes.getText().equals(" "))
                    {
                        Toast.makeText(PostExamples.this, "Must add image and description before you can post", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(PostExamples.this, "Post was successful", Toast.LENGTH_LONG).show();
                      sql.insertPictureData(path,descnotes.getText().toString());
                    }




                }
            });
        }


        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();

               imageView = (ImageView) findViewById(R.id.image);
                imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                path = picturePath;

            }


        }
    }



