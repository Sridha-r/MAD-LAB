package com.example.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class DatabaseActivity extends AppCompatActivity {

    Button insertBtn,viewBtn,updateBtn,deleteBtn;
    TextView outputTxt;

    DBHelper db;

    String name,transport,seat;
    int tickets,total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        insertBtn=findViewById(R.id.insertBtn);
        viewBtn=findViewById(R.id.viewBtn);
        updateBtn=findViewById(R.id.updateBtn);
        deleteBtn=findViewById(R.id.deleteBtn);
        outputTxt=findViewById(R.id.outputTxt);

        db=new DBHelper(this);

        name=getIntent().getStringExtra("name");
        tickets=getIntent().getIntExtra("tickets",0);
        transport=getIntent().getStringExtra("transport");
        seat=getIntent().getStringExtra("seat");
        total=getIntent().getIntExtra("total",0);

        insertBtn.setOnClickListener(v->{

            db.insertData(name,tickets,transport,seat,total);

            Toast.makeText(this,"Inserted",Toast.LENGTH_SHORT).show();

        });

        viewBtn.setOnClickListener(v->{

            Cursor c=db.getAllData();

            String data="";

            while(c.moveToNext()){

                data+=
                        "ID:"+c.getInt(0)+
                                "\nName:"+c.getString(1)+
                                "\nTickets:"+c.getInt(2)+
                                "\nTransport:"+c.getString(3)+
                                "\nSeat:"+c.getString(4)+
                                "\nPrice:"+c.getInt(5)+
                                "\n\n";
            }

            outputTxt.setText(data);

        });

        updateBtn.setOnClickListener(v->{

            db.updateData(1,"UpdatedName");

            Toast.makeText(this,"Updated ID 1",Toast.LENGTH_SHORT).show();

        });

        deleteBtn.setOnClickListener(v->{

            db.deleteData(1);

            Toast.makeText(this,"Deleted ID 1",Toast.LENGTH_SHORT).show();

        });
    }
}