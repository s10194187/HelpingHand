package com.example.helpinghand;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;

import java.util.HashMap;

public class SignUpMainActivity extends AppCompatActivity {
    EditText mFullName, mEmail, mPassword, mPassword2, mPhone;
    Button mRegisterButton;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_main);

        mFullName = findViewById(R.id.caregiverName);
        mEmail = findViewById(R.id.caregiverEmail);
        mPassword = findViewById(R.id.caregiverPassword);
        mPassword2 = findViewById(R.id.caregiverDuplicatePassword);
        mRegisterButton = findViewById(R.id.caregiverRegisterButton);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        if (fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        }

        mRegisterButton.setOnClickListener ((v) ->{
            String email = mEmail.getText().toString().trim();
            String password = mPassword.getText().toString().trim();
            String fullname = mFullName.getText().toString();

            if (TextUtils.isEmpty(email))
            {
                mEmail.setError("Email is required!");
                return;
            }


            if (TextUtils.isEmpty(password))
            {
                mPassword.setError("Password is required!");
                return;
            }

            if (TextUtils.isEmpty(fullname))
            {
                mFullName.setError("Name is required!");
                return;
            }

            if (password.length() < 6)
            {
                mPassword.setError("Password must be >= 6 characters");
                return;
            }

            //register the user in the firebase

            fAuth.createUserWithEmailAndPassword(email, password).AddOnCompleteListener((task) ->{

                if (task.isSuccessful()){
                    Toast.makeText(SignUpMainActivity.this, "User Created", Toast.LENGTH_SHORT).show();
                    userID = fAuth.getCurrentUser().getUid();
                    DocumentReference documentReference = fStore.collection("Caregivers").document(userID);
                    Map<String, Object> user = new HashMap<>();
                    user.put("fName", fullname);
                    user.put("email", email);
                    user.put("phone", phone);

                    Task<Void> voidTask = documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d(TAG, msg:"onSuccess: user profile is created for " + userID);
                        }
                    });
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                }

                else
                {

                }


            });

        });


    }
}