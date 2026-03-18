package com.example.myapplication;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {

    TextView tv;
    DatePicker dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv = findViewById(R.id.tvData);
        dp = findViewById(R.id.datePicker);

        // GET DATA
        String type = getIntent().getStringExtra("type");
        boolean oe = getIntent().getBooleanExtra("oe", false);
        boolean lab = getIntent().getBooleanExtra("lab", false);
        boolean cra = getIntent().getBooleanExtra("cra", false);
        boolean mess = getIntent().getBooleanExtra("mess", false);
        String gender = getIntent().getStringExtra("gender");

        tv.setText(
                "Type: " + type +
                "\nGender: " + gender +
                "\nOE: " + oe +
                "\nLab: " + lab +
                "\nCRA: " + cra +
                "\nMess: " + mess
        );

        // 🔥 Date restriction (no past dates)
        Calendar c = Calendar.getInstance();
        dp.setMinDate(c.getTimeInMillis());

        dp.setOnDateChangedListener((view, y, m, d) -> {
            String date = d + "/" + (m + 1) + "/" + y;
            Toast.makeText(this, "Selected: " + date, Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
    }

    // MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Menu 1");
        menu.add("Menu 2");
        return true;
    }
}

<activity android:name=".SecondActivity"/>

}
