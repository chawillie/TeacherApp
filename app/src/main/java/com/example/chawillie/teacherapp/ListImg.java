package com.example.chawillie.teacherapp;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by chawillie on 8/6/15.
 */
public class ListImg extends BaseAdapter implements View.OnClickListener{

    ArrayList<RowImg> myList = new ArrayList<RowImg>();
    LayoutInflater inflater;
    Context context;


    public ListImg(Context context, ArrayList<RowImg> myList) {
        this.myList = myList;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public RowImg getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder mViewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.postexamples3, parent, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        RowImg currentListData = getItem(position);

        mViewHolder.Title.setText(currentListData.getTitle());
        mViewHolder.Img.setImageBitmap(BitmapFactory.decodeFile(currentListData.getDescription()));


        return convertView;
    }

    @Override
    public void onClick(View v) {

    }

    private class MyViewHolder {
        TextView Title;
        ImageView Img;
        // ImageView ivIcon;

        public MyViewHolder(View item) {
            Title = (TextView) item.findViewById(R.id.postdesc);
            //Desc = (TextView) item.findViewById(R.id.post);
             Img = (ImageView) item.findViewById(R.id.postimg);
        }
    }
}




