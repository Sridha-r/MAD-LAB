package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button loginBtn,registerBtn;

    protected void onCreate(Bundle b)
    {
        super.onCreate(b);

        setContentView(R.layout.activity_main);

        loginBtn=findViewById(R.id.loginBtn);
        registerBtn=findViewById(R.id.registerBtn);

        loginBtn.setOnClickListener(v->
                startActivity(new Intent(this,LoginActivity.class)));

        registerBtn.setOnClickListener(v->
                startActivity(new Intent(this,RegisterActivity.class)));

    }
}