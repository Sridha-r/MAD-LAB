package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RiskCalculationActivity extends AppCompatActivity {

    TextView resultTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk);

        resultTxt = findViewById(R.id.resultTxt);

        int people = getIntent().getIntExtra("people",0);

        int risk = (people * 5) + 10;

        resultTxt.setText("Risk Amount = " + risk);
    }
}