package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class ComplaintActivity extends AppCompatActivity {

    EditText peopleInput;
    Button calcBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);

        peopleInput = findViewById(R.id.peopleInput);
        calcBtn = findViewById(R.id.calcBtn);

        calcBtn.setOnClickListener(v -> {

            int people = Integer.parseInt(peopleInput.getText().toString());

            Intent i = new Intent(this, RiskCalculationActivity.class);

            i.putExtra("people", people);

            startActivity(i);

        });
    }
}