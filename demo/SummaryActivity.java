package com.example.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    TextView txt;

    protected void onCreate(Bundle b)
    {
        super.onCreate(b);

        setContentView(R.layout.activity_summary);

        txt=findViewById(R.id.txt);

        DBHelper db=new DBHelper(this);

        db.insertMess(
                getIntent().getStringExtra("name"),
                getIntent().getStringExtra("regno"),
                getIntent().getStringExtra("cafe"),
                getIntent().getIntExtra("months",0),
                getIntent().getStringExtra("type"),
                getIntent().getIntExtra("total",0));

        Cursor c=db.getFullData(
                getIntent().getStringExtra("name"),
                getIntent().getStringExtra("regno"));

        String data="";

        while(c.moveToNext())
        {

            data+=
                    "Name:"+c.getString(1)+
                            "\nRole:"+c.getString(2)+
                            "\nRegNo:"+c.getString(3)+
                            "\nYear:"+c.getString(4)+
                            "\nDOB:"+c.getString(5)+
                            "\nCampus:"+c.getString(6)+
                            "\nSubjects:"+c.getString(7)+

                            "\nCafeteria:"+c.getString(11)+
                            "\nMonths:"+c.getInt(12)+
                            "\nType:"+c.getString(13)+
                            "\nTotal:"+c.getInt(14)+

                            "\n\n";
        }

        txt.setText(data);

    }
}