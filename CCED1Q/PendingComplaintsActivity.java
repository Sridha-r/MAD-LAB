package com.example.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PendingComplaintsActivity extends AppCompatActivity {

    TextView txt;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending);

        txt = findViewById(R.id.pendingTxt);

        db = new DBHelper(this);

        Cursor c = db.getPendingComplaints();

        String data="";

        while(c.moveToNext()){

            data += "Type: " + c.getString(1)
                    + "\nDate: " + c.getString(2)
                    + "\n\n";
        }

        txt.setText(data);
    }
}