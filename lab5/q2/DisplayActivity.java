package com.example.myapplication;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    TextView tvResult;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tvResult = findViewById(R.id.tvResult);
        btnBack = findViewById(R.id.btnBack);

        String source = getIntent().getStringExtra("source");
        String destination = getIntent().getStringExtra("destination");
        String date = getIntent().getStringExtra("date");
        String trip = getIntent().getStringExtra("trip");

        tvResult.setText(
                "Source: " + source +
                "\nDestination: " + destination +
                "\nDate: " + date +
                "\nTrip Type: " + trip
        );

        btnBack.setOnClickListener(v -> finish());
    }
}
