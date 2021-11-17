package com.example.helpinghand;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class MedicationAlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication_alarm);

        TextView currentDate = findViewById(R.id.medicationCurrentDate);
        TextView medicationList = findViewById(R.id.medicationList);

        setCurrentDay(currentDate);
    }

    private void setCurrentDay(TextView t){
        long date = System.currentTimeMillis();

        SimpleDateFormat sdf = new SimpleDateFormat("DD Mon yyyy");
        String dateString = sdf.format(date);
        t.setText(dateString);
    }
}