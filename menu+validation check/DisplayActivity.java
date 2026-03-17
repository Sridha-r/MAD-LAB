package com.example.myapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    TextView tvData;

    boolean hostel, mess, classes, npacn, nplab, lab, oe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tvData = findViewById(R.id.tvData);

        String name = getIntent().getStringExtra("name");
        String adm = getIntent().getStringExtra("adm");
        String date = getIntent().getStringExtra("date");
        String time = getIntent().getStringExtra("time");

        hostel = getIntent().getBooleanExtra("hostel", false);
        mess = getIntent().getBooleanExtra("mess", false);
        classes = getIntent().getBooleanExtra("classes", false);
        npacn = getIntent().getBooleanExtra("npacn", false);
        nplab = getIntent().getBooleanExtra("nplab", false);
        lab = getIntent().getBooleanExtra("lab", false);
        oe = getIntent().getBooleanExtra("oe", false);

        tvData.setText(
                "Name: " + name +
                        "\nAdmission: " + adm +
                        "\nDate: " + date +
                        "\nTime: " + time
        );
    }

    // MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Hostel Details");
        menu.add("Classes Details");
        menu.add("Lab Details");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getTitle().equals("Hostel Details")) {
            tvData.append("\n\nHostel: " + hostel + "\nMess: " + mess);
        }

        else if (item.getTitle().equals("Classes Details")) {
            tvData.append("\n\nClasses: " + classes +
                    "\nNPACN: " + npacn +
                    "\nNP Lab: " + nplab);
        }

        else if (item.getTitle().equals("Lab Details")) {
            tvData.append("\n\nLab: " + lab + "\nOE: " + oe);
        }

        return true;
    }
}
