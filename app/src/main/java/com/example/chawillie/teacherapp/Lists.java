package com.example.chawillie.teacherapp;

import android.app.Activity;
import android.app.UiAutomation;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.zip.Inflater;

/**
 * Created by chawillie on 8/3/15.
 */
public class Lists extends BaseAdapter implements View.OnClickListener{

    ArrayList<Row> myList = new ArrayList<Row>();
    LayoutInflater inflater;
    Context context;


    public Lists(Context context, ArrayList<Row> myList) {
        this.myList = myList;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Row getItem(int position) {
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
            convertView = inflater.inflate(R.layout.calender, parent, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

      Row currentListData = getItem(position);

        mViewHolder.Title.setText(currentListData.getTitle());
        mViewHolder.Desc.setText(currentListData.getDescription());


        return convertView;
    }

    @Override
    public void onClick(View v) {

    }

    private class MyViewHolder {
        TextView Title, Desc;
       // ImageView ivIcon;

        public MyViewHolder(View item) {
            Title = (TextView) item.findViewById(R.id.textView6);
            Desc = (TextView) item.findViewById(R.id.textView7);
           // ivIcon = (ImageView) item.findViewById(R.id.ivIcon);
        }
    }
}



