package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    Button confirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        confirmBtn = findViewById(R.id.confirmBtn);

        confirmBtn.setOnClickListener(v -> {

            Intent i = new Intent(LoginActivity.this, DashboardActivity.class);

            startActivity(i);

        });
    }
}