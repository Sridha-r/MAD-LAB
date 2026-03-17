package com.example.myapplication;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class PreviewActivity extends AppCompatActivity {

    TextView tvDetails;
    Button btnConfirm, btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        tvDetails = findViewById(R.id.tvDetails);
        btnConfirm = findViewById(R.id.btnConfirm);
        btnEdit = findViewById(R.id.btnEdit);

        String type = getIntent().getStringExtra("type");
        String vno = getIntent().getStringExtra("vno");
        String rc = getIntent().getStringExtra("rc");

        tvDetails.setText("Vehicle Type: " + type +
                "\nVehicle No: " + vno +
                "\nRC No: " + rc);

        btnConfirm.setOnClickListener(v -> {
            int serial = new Random().nextInt(10000);
            Toast.makeText(this,
                    "Parking Confirmed! Serial No: " + serial,
                    Toast.LENGTH_LONG).show();
        });

        btnEdit.setOnClickListener(v -> finish());
    }
}
