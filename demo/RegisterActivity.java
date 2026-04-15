package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    EditText name,regno,year,dob;
    Spinner role;
    Switch campus;
    CheckBox a,b,c;
    Button registerBtn;

    DBHelper db;

    protected void onCreate(Bundle s)
    {
        super.onCreate(s);

        setContentView(R.layout.activity_register);

        name=findViewById(R.id.name);
        regno=findViewById(R.id.regno);
        year=findViewById(R.id.year);
        dob=findViewById(R.id.dob);

        role=findViewById(R.id.role);

        campus=findViewById(R.id.campus);

        a=findViewById(R.id.a);
        b=findViewById(R.id.b);
        c=findViewById(R.id.c);

        registerBtn=findViewById(R.id.registerBtn);

        db=new DBHelper(this);

        String[] r={"Teacher","Student"};

        role.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,r));

        dob.setOnClickListener(v->{

            Calendar cal=Calendar.getInstance();

            new DatePickerDialog(this,
                    (d,y,m,day)->dob.setText(day+"/"+(m+1)+"/"+y),
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show();

        });

        registerBtn.setOnClickListener(v->{

            String subjects="";

            if(a.isChecked()) subjects+="A ";
            if(b.isChecked()) subjects+="B ";
            if(c.isChecked()) subjects+="C ";

            db.insertUser(
                    name.getText().toString(),
                    role.getSelectedItem().toString(),
                    regno.getText().toString(),
                    year.getText().toString(),
                    dob.getText().toString(),
                    campus.isChecked()?"Yes":"No",
                    subjects);

            Toast.makeText(this,
                    "Registered - go to login",
                    Toast.LENGTH_LONG).show();

            startActivity(new Intent(this,LoginActivity.class));

        });
    }
}