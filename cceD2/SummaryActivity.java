package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    TextView summaryTxt;
    Button editBtn,nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        summaryTxt=findViewById(R.id.summaryTxt);
        editBtn=findViewById(R.id.editBtn);
        nextBtn=findViewById(R.id.nextBtn);

        Intent i=getIntent();

        String data=
                "Name: "+i.getStringExtra("name")+
                        "\nTickets: "+i.getIntExtra("tickets",0)+
                        "\nTransport: "+i.getStringExtra("transport")+
                        "\nSeat: "+i.getStringExtra("seat")+
                        "\nTotal Price: "+i.getIntExtra("total",0);

        summaryTxt.setText(data);

        editBtn.setOnClickListener(v-> finish());

        nextBtn.setOnClickListener(v->{

            Intent dbIntent=new Intent(this,DatabaseActivity.class);

            dbIntent.putExtras(i);

            startActivity(dbIntent);

        });
    }
}