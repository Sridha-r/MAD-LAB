package com.example.myapplication;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    TextView tvDetails;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tvDetails = findViewById(R.id.tvDetails);
        btnBack = findViewById(R.id.btnBack);

        String movie = getIntent().getStringExtra("movie");
        String theatre = getIntent().getStringExtra("theatre");
        String date = getIntent().getStringExtra("date");
        String time = getIntent().getStringExtra("time");
        String type = getIntent().getStringExtra("type");
        int seats = getIntent().getIntExtra("seats", 0);

        tvDetails.setText(
                "Movie: " + movie +
                "\nTheatre: " + theatre +
                "\nDate: " + date +
                "\nTime: " + time +
                "\nTicket Type: " + type +
                "\nAvailable Seats: " + seats
        );

        btnBack.setOnClickListener(v -> finish());
    }
}

<activity android:name=".DisplayActivity"/>
