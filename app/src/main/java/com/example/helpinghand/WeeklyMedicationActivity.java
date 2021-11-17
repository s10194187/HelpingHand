package com.example.helpinghand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WeeklyMedicationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_medication);

        Button weeklyMedBackButton = findViewById(R.id.weeklyMedicationBackButton);

        weeklyMedBackButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent navigateToPreviousPage = new Intent(WeeklyMedicationActivity.this, MedicationAlarmActivity.class);
                startActivity(navigateToPreviousPage);
            }
        });
    }
}