package com.example.sahil.registration;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

import java.util.regex.Pattern;

public class signup extends AppCompatActivity {

    private ProgressBar progressbar;
    private EditText Email;
    private EditText Password;
    private FirebaseAuth firebaseAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firebaseAuth = FirebaseAuth.getInstance();


        //Name = (EditText)findViewById(R.id.etName);
        Email = findViewById(R.id.etEmail);
        Password = findViewById(R.id.etPassword);
        Button signup = findViewById(R.id.btnSignup);
        progressbar = (ProgressBar)findViewById(R.id.progressbar);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Upload this data to database

                String user_Email = Email.getText().toString().trim();
                String user_Password = Password.getText().toString().trim();

                if(user_Email.isEmpty())
                {
                    Email.setError("Email is required");
                    Email.requestFocus();
                    return;
                }


                if(!Patterns.EMAIL_ADDRESS.matcher(user_Email).matches())
                {
                    Email.setError("Please enter a valid email");
                    Email.requestFocus();

                }
                if(user_Password.isEmpty())
                {
                    Password.setError("Password is required");
                    Password.requestFocus();

                }

                if(Password.length() < 6)
                {
                    Password.setError("Minimum length of Password should be 6");
                    Password.requestFocus();
                }

                progressbar.setVisibility(View.VISIBLE);

                firebaseAuth.createUserWithEmailAndPassword(user_Email,user_Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressbar.setVisibility(View.GONE);

                        if (task.isSuccessful()) {


                            Intent myIntent = new Intent(signup.this, userRegistraion.class);
                            startActivity(myIntent);

                            Toast.makeText(getApplicationContext(), "User Registration Successfull", Toast.LENGTH_SHORT).show();
                            //Toast.makeText(com.example.sahil.registration.signup.this,"Signup Successful",Toast.LENGTH_SHORT).show();
                        } else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                Toast.makeText(getApplicationContext(), "You are already registered ", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                                Intent myIntent = new Intent(com.example.sahil.registration.signup.this, signup.class);
                                startActivity(myIntent);
                            }
                        }
                    }
                });
            }



        });

    }

}
