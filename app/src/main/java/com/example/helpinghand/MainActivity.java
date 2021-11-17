package com.example.helpinghand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sosButton = findViewById(R.id.sosButton);
        sosButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.sosButton:
                        Toast.makeText(getApplicationContext(), "SOS Button activated", Toast.LENGTH_SHORT).show();

                }
            }
        });

        Button lostButton = findViewById(R.id.lostButton);
        lostButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent navigateToLostPage = new Intent(MainActivity.this,HelpLostActivity.class);
                startActivity(navigateToLostPage);
            }

        });


    }


    }


