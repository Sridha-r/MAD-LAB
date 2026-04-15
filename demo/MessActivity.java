package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MessActivity extends AppCompatActivity {

    Spinner cafe;
    EditText months;
    RadioGroup type;
    Button calcBtn;

    String name,regno;

    protected void onCreate(Bundle b)
    {
        super.onCreate(b);

        setContentView(R.layout.activity_mess);

        name=getIntent().getStringExtra("name");
        regno=getIntent().getStringExtra("regno");

        cafe=findViewById(R.id.cafe);
        months=findViewById(R.id.months);
        type=findViewById(R.id.type);
        calcBtn=findViewById(R.id.calcBtn);

        String[] c={"X","Y","Z"};

        cafe.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,c));

        calcBtn.setOnClickListener(v->{

            int m=Integer.parseInt(months.getText().toString());

            RadioButton r=findViewById(type.getCheckedRadioButtonId());

            int total=
                    r.getText().toString().equals("Veg")
                            ? m*150
                            : m*200;

            Intent i=new Intent(this,SummaryActivity.class);

            i.putExtra("name",name);
            i.putExtra("regno",regno);
            i.putExtra("cafe",cafe.getSelectedItem().toString());
            i.putExtra("months",m);
            i.putExtra("type",r.getText().toString());
            i.putExtra("total",total);

            startActivity(i);

        });
    }
}