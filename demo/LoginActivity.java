package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText name,regno;
    Button loginBtn;

    DBHelper db;

    protected void onCreate(Bundle b)
    {
        super.onCreate(b);

        setContentView(R.layout.activity_login);

        name=findViewById(R.id.name);
        regno=findViewById(R.id.regno);
        loginBtn=findViewById(R.id.loginBtn);

        db=new DBHelper(this);

        loginBtn.setOnClickListener(v->{

            if(db.checkLogin(
                    name.getText().toString(),
                    regno.getText().toString()))
            {

                Intent i=new Intent(this,MessActivity.class);

                i.putExtra("name",name.getText().toString());
                i.putExtra("regno",regno.getText().toString());

                startActivity(i);

            }
            else
                Toast.makeText(this,
                        "User not registered",
                        Toast.LENGTH_SHORT).show();

        });
    }
}