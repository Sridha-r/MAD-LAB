package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Spinner spSource, spDestination;
    DatePicker datePicker;
    ToggleButton toggleTrip;
    Button btnSubmit, btnReset;

    String[] cities = {"Select City", "Mumbai", "Delhi", "Bangalore", "Chennai"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spSource = findViewById(R.id.spSource);
        spDestination = findViewById(R.id.spDestination);
        datePicker = findViewById(R.id.datePicker);
        toggleTrip = findViewById(R.id.toggleTrip);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnReset = findViewById(R.id.btnReset);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, cities);

        spSource.setAdapter(adapter);
        spDestination.setAdapter(adapter);

        // SUBMIT
        btnSubmit.setOnClickListener(v -> {

            String source = spSource.getSelectedItem().toString();
            String destination = spDestination.getSelectedItem().toString();

            int day = datePicker.getDayOfMonth();
            int month = datePicker.getMonth() + 1;
            int year = datePicker.getYear();

            String date = day + "/" + month + "/" + year;

            String tripType = toggleTrip.isChecked() ? "Round Trip" : "One Way";

            if (source.equals("Select City") || destination.equals("Select City")) {
                Toast.makeText(this, "Select valid cities", Toast.LENGTH_SHORT).show();
            } else {

                Intent i = new Intent(this, DisplayActivity.class);
                i.putExtra("source", source);
                i.putExtra("destination", destination);
                i.putExtra("date", date);
                i.putExtra("trip", tripType);

                startActivity(i);
            }
        });

        // RESET
        btnReset.setOnClickListener(v -> {

            spSource.setSelection(0);
            spDestination.setSelection(0);
            toggleTrip.setChecked(false);

            // Reset date to current
            Calendar c = Calendar.getInstance();
            datePicker.updateDate(
                    c.get(Calendar.YEAR),
                    c.get(Calendar.MONTH),
                    c.get(Calendar.DAY_OF_MONTH)
            );

            Toast.makeText(this, "Reset Done", Toast.LENGTH_SHORT).show();
        });
    }
}


<activity android:name=".DisplayActivity"/>
