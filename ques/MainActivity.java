package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggle;
    CheckBox cbOE, cbLab, cbCRA, cbMess;
    RadioGroup rg;
    Button btnOK, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggle = findViewById(R.id.toggleType);
        cbOE = findViewById(R.id.cbOE);
        cbLab = findViewById(R.id.cbLab);
        cbCRA = findViewById(R.id.cbCRA);
        cbMess = findViewById(R.id.cbMess);
        rg = findViewById(R.id.radioGroup);
        btnOK = findViewById(R.id.btnOK);
        btnClear = findViewById(R.id.btnClear);

        // 🔥 Toggle logic
        toggle.setOnCheckedChangeListener((b, checked) -> {
            if (checked) {
                cbMess.setChecked(true); // hostel → mess compulsory
            }
        });

        // OK button
        btnOK.setOnClickListener(v -> {

            String type = toggle.isChecked() ? "Hostelite" : "Off-Campus";

            String gender = "";
            int selected = rg.getCheckedRadioButtonId();
            if (selected == R.id.rbMale) gender = "Male";
            else if (selected == R.id.rbFemale) gender = "Female";
            else if (selected == R.id.rbOther) gender = "Others";

            Intent i = new Intent(this, SecondActivity.class);
            i.putExtra("type", type);
            i.putExtra("oe", cbOE.isChecked());
            i.putExtra("lab", cbLab.isChecked());
            i.putExtra("cra", cbCRA.isChecked());
            i.putExtra("mess", cbMess.isChecked());
            i.putExtra("gender", gender);

            startActivity(i);
        });

        // CLEAR button
        btnClear.setOnClickListener(v -> {
            toggle.setChecked(false);
            cbOE.setChecked(false);
            cbLab.setChecked(false);
            cbCRA.setChecked(false);
            cbMess.setChecked(false);
            rg.clearCheck();
        });
    }
}
