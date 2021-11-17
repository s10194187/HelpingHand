package com.example.helpinghand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginToElderlyButton = findViewById(R.id.elderlyMainPageButton);
        loginToElderlyButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent navigateToElderlyPage = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(navigateToElderlyPage);
            }
        });

        Button loginToCaregiverButton = findViewById(R.id.CaregiverPageButton);
        loginToCaregiverButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent navigateToCaregiverPage = new Intent(LoginActivity.this, CaregiverMainActivity.class);
                startActivity(navigateToCaregiverPage);
            }
        });







    }
}