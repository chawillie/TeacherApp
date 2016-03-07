package com.example.chawillie.teacherapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by chawillie on 7/30/15.
 */
public class SQL extends SQLiteOpenHelper {
    public static final String Database_Name = "TeacherData.db";
    public static final String Table_Name = "Teacherplan";
    public static final String Col_1 = "EventID";
    public static final String Col_2 = "EventName";
    public static final String Col_3 = "ClassName";
    public static final String Col_4 = "Date";
    public static final String Col_5 = "Time";
    public static final String Col_6 = "Description";
    public static final String Col_7 = "SchedDate";
    public static final String Col_8 = "SchedTime";
    public static final String Table_Name1 = "Post";
    public static final String Col_1_1 = "PostID";
    public static final String Col_2_1 = "PicturePath";
    public static final String Col_3_1 = "PictureDesc";
    public static final String Table_Name2 = "Review";
    public static final String Col_1_2 = "ClassID";
    public static final String Col_2_2 = "ReviewDate";
    public static final String Col_3_2 = "SubjectName";
    public static final String Col_4_2 = "Review";
    public static final String Table_Name3 = "StudentInfo";
    public static final String Col_1_3 = "StudentName";
    public static final String Col_2_3 = "Age";
    public static final String Col_3_3 = "SecurityCode";
    public static final String Col_4_3 = "ClassName";
    public static final String Table_Name4 = "Parent";
    public static final String Col_0_4 = "StudentCode";
    public static final String Col_1_4 = "Assess1";
    public static final String Col_2_4 = "Assess2";
    public static final String Col_3_4 = "Assess3";
    public static final String Col_4_4 = "Assess4";
    public static final String Col_5_4 = "Status1";
    public static final String Col_6_4 = "Status2";
    public static final String Col_7_4 = "Status3";
    public static final String Col_8_4 = "Status4";


    public SQL(Context context) {
        super(context, Database_Name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Table_Name + "(EventID INTEGER PRIMARY KEY AUTOINCREMENT, EventName TEXT, ClassName TEXT, Date TEXT, Time TEXT, Description TEXT, SchedDate TEXT, SchedTime TEXT)");
        db.execSQL("create table " + Table_Name1 + "(PostID INTEGER PRIMARY KEY AUTOINCREMENT, PicturePath TEXT, PictureDesc TEXT)");
        db.execSQL("create table " + Table_Name2 + "(ClassID INTEGER PRIMARY KEY AUTOINCREMENT, ReviewDate TEXT, SubjectName TEXT, Review TEXT)");
        db.execSQL("create table " + Table_Name3 + "(SecurityCode INTEGER, StudentName TEXT, Age INTEGER, ClassName TEXT)");
        db.execSQL("create table " + Table_Name4 + "(SecurityCode INTEGER, Assess1 TEXT, Assess2 TEXT, Assess3 TEXT, Assess4 TEXT, Status1 TEXT, Status2 TEXT, Status3 TEXT, Status4 TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        onCreate(db);
    }

    public boolean insertData(String eventname, String classname,String date, String time, String Description, String scheduledate, String scheduletime)
    {
        SQLiteDatabase db_sql = this.getWritableDatabase();
        ContentValues content =  new ContentValues();
        content.put(Col_2,eventname);
        content.put(Col_3,classname);
        content.put(Col_4,date);
        content.put(Col_5,time);
        content.put(Col_6,Description);
        content.put(Col_7,scheduledate);
        content.put(Col_8,scheduletime);
       long result =  db_sql.insert(Table_Name,null,content);

        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    public boolean insertparentview(int code, String classname,String date, String time, String time1, String Description, String scheduledate, String scheduletime,String status)
    {
        SQLiteDatabase db_sql = this.getWritableDatabase();
        ContentValues content =  new ContentValues();
        content.put(Col_0_4,code);
        content.put(Col_1_4,classname);
        content.put(Col_2_4,date);
        content.put(Col_3_4,time);
        content.put(Col_4_4,time1);
        content.put(Col_5_4,Description);
        content.put(Col_6_4,scheduledate);
        content.put(Col_7_4,scheduletime);
        content.put(Col_8_4,status);
        long result =  db_sql.insert(Table_Name4,null,content);

        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    public boolean insertPictureData(String picturepath, String picturedesc)
    {
        SQLiteDatabase db_sql = this.getWritableDatabase();
        ContentValues content =  new ContentValues();
        content.put(Col_2_1,picturepath);
        content.put(Col_3_1,picturedesc);

        long result =  db_sql.insert(Table_Name1,null,content);

        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    public boolean studentData(int code, String name,int age, String classname )
    {
        SQLiteDatabase db_sql = this.getWritableDatabase();
        ContentValues content =  new ContentValues();
        content.put(Col_3_3,code);
        content.put(Col_1_3,name);
        content.put(Col_2_3,age);
        content.put(Col_4_3,classname);

        long result =  db_sql.insert(Table_Name3,null,content);

        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    public boolean insertReviewData(String date, String subject,String review)
    {
        SQLiteDatabase db_sql = this.getWritableDatabase();
        ContentValues content =  new ContentValues();
        content.put(Col_2_2,date);
        content.put(Col_3_2,subject);
        content.put(Col_4_2,review);

        long result =  db_sql.insert(Table_Name2,null,content);

        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    public Cursor getEventinfo()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT "+Col_2+" , "+Col_4+" FROM "+Table_Name,null);
        return res;
    }

    public Cursor getPictureinfo()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT "+Col_2_1+" , "+Col_3_1+" FROM "+Table_Name1,null);
        return res;
    }
    public Cursor getPicture(int pos)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT "+Col_2_1+" FROM "+Table_Name1+" WHERE "+Col_1_1 +" ='"+pos+"'",null);
        return res;
    }

    public Cursor studName(int pos)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT "+Col_1_3+" FROM "+Table_Name3+" WHERE "+Col_3_3 +" ='"+pos+"'",null);
        return res;
    }



    public Cursor DisplayDetails(int pos)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+Table_Name+" WHERE "+Col_1 +" ='"+pos+"'",null);
        return res;
    }
    public Cursor Displayreview()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+Table_Name2,null);
        return res;
    }
public  boolean Update(String id, String eventname, String classname,String date, String time, String Description, String scheduledate, String scheduletime)
{
    SQLiteDatabase db_sql = this.getWritableDatabase();
    ContentValues content =  new ContentValues();
    content.put(Col_2,eventname);
    content.put(Col_3,classname);
    content.put(Col_4,date);
    content.put(Col_5,time);
    content.put(Col_6,Description);
    content.put(Col_7,scheduledate);
    content.put(Col_8,scheduletime);
    long result =  db_sql.update(Table_Name,content,"EventID = ?",new String[]{id});

    if(result == -1)
    {
        return false;
    }
    else
    {
        return true;
    }

}

    public Cursor Codecheck(int pos)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT "+Col_3_3+" FROM "+Table_Name3+" WHERE "+Col_3_3 +" ='"+pos+"'",null);
        return res;
    }

    public Cursor Displayparentinfo()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+Table_Name4,null);
        return res;
    }

}
