package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "TravelDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE booking(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "tickets INTEGER," +
                "transport TEXT," +
                "seat TEXT," +
                "price INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS booking");
        onCreate(db);
    }

    public void insertData(String name,int tickets,String transport,String seat,int price){

        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();

        cv.put("name",name);
        cv.put("tickets",tickets);
        cv.put("transport",transport);
        cv.put("seat",seat);
        cv.put("price",price);

        db.insert("booking",null,cv);
    }

    public Cursor getAllData(){

        SQLiteDatabase db=this.getReadableDatabase();

        return db.rawQuery("SELECT * FROM booking",null);
    }

    public void updateData(int id,String name){

        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();

        cv.put("name",name);

        db.update("booking",cv,"id=?",new String[]{String.valueOf(id)});
    }

    public void deleteData(int id){

        SQLiteDatabase db=this.getWritableDatabase();

        db.delete("booking","id=?",new String[]{String.valueOf(id)});
    }
}