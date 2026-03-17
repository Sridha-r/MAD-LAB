package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText etName, etAdm;
    CheckBox cbHostel, cbClasses, cbLab, cbOE;
    CheckBox cbMess, cbNPACN, cbNPLab;
    DatePicker datePicker;
    TimePicker timePicker;
    Button btnSubmit, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etAdm = findViewById(R.id.etAdm);

        cbHostel = findViewById(R.id.cbHostel);
        cbClasses = findViewById(R.id.cbClasses);
        cbLab = findViewById(R.id.cbLab);
        cbOE = findViewById(R.id.cbOE);

        cbMess = findViewById(R.id.cbMess);
        cbNPACN = findViewById(R.id.cbNPACN);
        cbNPLab = findViewById(R.id.cbNPLab);

        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnReset = findViewById(R.id.btnReset);

        // 🔥 LOGIC

        cbHostel.setOnCheckedChangeListener((b, checked) -> {
            cbMess.setChecked(checked); // auto select mess
        });

        cbClasses.setOnCheckedChangeListener((b, checked) -> {
            if (checked) {
                cbNPACN.setChecked(true);
                cbNPLab.setChecked(true);
            }
        });

        cbLab.setOnCheckedChangeListener((b, checked) -> {
            if (checked) {
                cbNPLab.setChecked(true);
            }
        });

        // SUBMIT
        btnSubmit.setOnClickListener(v -> {

            String name = etName.getText().toString();
            String adm = etAdm.getText().toString();

            if (name.isEmpty() || adm.isEmpty()) {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            int d = datePicker.getDayOfMonth();
            int m = datePicker.getMonth() + 1;
            int y = datePicker.getYear();

            int h = timePicker.getHour();
            int min = timePicker.getMinute();

            String date = d + "/" + m + "/" + y;
            String time = h + ":" + min;

            Intent i = new Intent(this, DisplayActivity.class);

            i.putExtra("name", name);
            i.putExtra("adm", adm);

            i.putExtra("hostel", cbHostel.isChecked());
            i.putExtra("mess", cbMess.isChecked());
            i.putExtra("classes", cbClasses.isChecked());
            i.putExtra("npacn", cbNPACN.isChecked());
            i.putExtra("nplab", cbNPLab.isChecked());
            i.putExtra("lab", cbLab.isChecked());
            i.putExtra("oe", cbOE.isChecked());

            i.putExtra("date", date);
            i.putExtra("time", time);

            startActivity(i);
        });

        // RESET
        btnReset.setOnClickListener(v -> {

            etName.setText("");
            etAdm.setText("");

            cbHostel.setChecked(false);
            cbClasses.setChecked(false);
            cbLab.setChecked(false);
            cbOE.setChecked(false);

            cbMess.setChecked(false);
            cbNPACN.setChecked(false);
            cbNPLab.setChecked(false);

            Calendar c = Calendar.getInstance();
            datePicker.updateDate(
                    c.get(Calendar.YEAR),
                    c.get(Calendar.MONTH),
                    c.get(Calendar.DAY_OF_MONTH)
            );

            Toast.makeText(this, "Reset Done", Toast.LENGTH_SHORT).show();
        });
    }
}
