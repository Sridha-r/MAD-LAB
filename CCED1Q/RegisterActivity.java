package com.example.myapplication;

import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterActivity extends AppCompatActivity {

    Spinner spinner;
    CheckBox resolvedCheck;
    Button saveBtn;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        spinner = findViewById(R.id.spinnerType);
        resolvedCheck = findViewById(R.id.checkboxResolved);
        saveBtn = findViewById(R.id.saveBtn);

        db = new DBHelper(this);

        String[] types = {"Network", "Water", "Electricity"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, types);

        spinner.setAdapter(adapter);

        saveBtn.setOnClickListener(v -> {

            String type = spinner.getSelectedItem().toString();

            String date = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());

            db.insertComplaint(type, date, resolvedCheck.isChecked());

            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();

        });
    }
}