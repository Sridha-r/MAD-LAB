package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Spinner spMovie, spTheatre;
    DatePicker datePicker;
    TimePicker timePicker;
    ToggleButton toggleTicket;
    Button btnBook, btnReset;

    String[] movies = {"Select Movie", "Avengers", "Inception", "Interstellar"};
    String[] theatres = {"Select Theatre", "PVR", "INOX", "Cinepolis"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spMovie = findViewById(R.id.spMovie);
        spTheatre = findViewById(R.id.spTheatre);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        toggleTicket = findViewById(R.id.toggleTicket);
        btnBook = findViewById(R.id.btnBook);
        btnReset = findViewById(R.id.btnReset);

        ArrayAdapter<String> movieAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, movies);

        ArrayAdapter<String> theatreAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, theatres);

        spMovie.setAdapter(movieAdapter);
        spTheatre.setAdapter(theatreAdapter);

        // BOOK BUTTON
        btnBook.setOnClickListener(v -> {

            String movie = spMovie.getSelectedItem().toString();
            String theatre = spTheatre.getSelectedItem().toString();

            int day = datePicker.getDayOfMonth();
            int month = datePicker.getMonth() + 1;
            int year = datePicker.getYear();

            int hour = timePicker.getHour();
            int minute = timePicker.getMinute();

            String time = hour + ":" + minute;
            String date = day + "/" + month + "/" + year;

            String ticketType = toggleTicket.isChecked() ? "Premium" : "Standard";

            // VALIDATION
            if (movie.equals("Select Movie") || theatre.equals("Select Theatre")) {
                Toast.makeText(this, "Select movie and theatre", Toast.LENGTH_SHORT).show();
                return;
            }

            // PREMIUM CONDITION
            if (ticketType.equals("Premium") && hour < 12) {
                Toast.makeText(this, "Premium booking allowed only after 12 PM", Toast.LENGTH_LONG).show();
                return;
            }

            // RANDOM SEATS
            int seats = new Random().nextInt(50) + 1;

            Intent i = new Intent(this, DisplayActivity.class);
            i.putExtra("movie", movie);
            i.putExtra("theatre", theatre);
            i.putExtra("date", date);
            i.putExtra("time", time);
            i.putExtra("type", ticketType);
            i.putExtra("seats", seats);

            startActivity(i);
        });

        // RESET BUTTON
        btnReset.setOnClickListener(v -> {

            spMovie.setSelection(0);
            spTheatre.setSelection(0);
            toggleTicket.setChecked(false);

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
