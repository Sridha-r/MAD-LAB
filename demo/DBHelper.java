package com.example.myapplication;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.*;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context c)
    {
        super(c,"CollegeDB",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        db.execSQL("CREATE TABLE users(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "role TEXT," +
                "regno TEXT," +
                "year TEXT," +
                "dob TEXT," +
                "campus TEXT," +
                "subjects TEXT)");

        db.execSQL("CREATE TABLE mess(" +
                "mid INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "regno TEXT," +
                "cafeteria TEXT," +
                "months INTEGER," +
                "type TEXT," +
                "total INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int o,int n)
    {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS mess");
        onCreate(db);
    }

    public void insertUser(String name,String role,String regno,
                           String year,String dob,String campus,String subjects)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();

        cv.put("name",name);
        cv.put("role",role);
        cv.put("regno",regno);
        cv.put("year",year);
        cv.put("dob",dob);
        cv.put("campus",campus);
        cv.put("subjects",subjects);

        db.insert("users",null,cv);
    }

    public boolean checkLogin(String name,String regno)
    {
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor c=db.rawQuery(
                "SELECT * FROM users WHERE name=? AND regno=?",
                new String[]{name,regno});

        return c.getCount()>0;
    }

    public void insertMess(String name,String regno,
                           String cafe,int months,String type,int total)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();

        cv.put("name",name);
        cv.put("regno",regno);
        cv.put("cafeteria",cafe);
        cv.put("months",months);
        cv.put("type",type);
        cv.put("total",total);

        db.insert("mess",null,cv);
    }

    public Cursor getFullData(String name,String regno)
    {
        SQLiteDatabase db=this.getReadableDatabase();

        return db.rawQuery(
                "SELECT * FROM users u JOIN mess m " +
                        "ON u.name=m.name AND u.regno=m.regno " +
                        "WHERE u.name=? AND u.regno=?",
                new String[]{name,regno});
    }

}