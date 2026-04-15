package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class BookingActivity extends AppCompatActivity {

    EditText nameInput,ticketInput;
    Spinner transportSpinner;
    RadioGroup seatGroup;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        nameInput=findViewById(R.id.nameInput);
        ticketInput=findViewById(R.id.ticketInput);
        transportSpinner=findViewById(R.id.transportSpinner);
        seatGroup=findViewById(R.id.seatGroup);
        submitBtn=findViewById(R.id.submitBtn);

        String[] transport={"Bus","Train","Car"};

        ArrayAdapter<String> adapter=
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        transport);

        transportSpinner.setAdapter(adapter);

        submitBtn.setOnClickListener(v->{

            String name=nameInput.getText().toString();

            int tickets=Integer.parseInt(ticketInput.getText().toString());

            String transportType=transportSpinner.getSelectedItem().toString();

            int selectedSeat=seatGroup.getCheckedRadioButtonId();

            RadioButton rb=findViewById(selectedSeat);

            String seat=rb.getText().toString();

            int price=0;

            if(transportType.equals("Bus"))
                price=500;

            if(transportType.equals("Train"))
                price=800;

            if(transportType.equals("Car"))
                price=1000;

            int total=tickets*price;

            Intent i=new Intent(this,SummaryActivity.class);

            i.putExtra("name",name);
            i.putExtra("tickets",tickets);
            i.putExtra("transport",transportType);
            i.putExtra("seat",seat);
            i.putExtra("total",total);

            startActivity(i);

        });
    }
}