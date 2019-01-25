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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Mainpage extends AppCompatActivity {

    private Button event1;
    private Button event2;
    private Button event3;
    private Button event4;
    //private Button event5;
    //private Button event6;
    private EditText UserEmail;
    private EditText UserPassword;
    private TextView Info;
    private Button SignIn;
    //private Button SignUp;
    private FirebaseAuth firebaseAuth;
    private ProgressBar progressbar;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        event1 = (Button)findViewById(R.id.btnev1);
        event2 = (Button)findViewById(R.id.btnev2);
        event3 = (Button)findViewById(R.id.btnev3);
        event4 = (Button)findViewById(R.id.btnev4);


        firebaseAuth = FirebaseAuth.getInstance();
        UserEmail = (EditText)findViewById(R.id.etusrEmail);
        UserPassword = (EditText)findViewById(R.id.etPassword);
        Info = (TextView) findViewById(R.id.tvinfo);
        SignIn = (Button)findViewById(R.id.btnSignin);
        //SignUp = (Button)findViewById(R.id.btnSignup);

        progressbar = (ProgressBar)findViewById(R.id.progressbar2);

        Info.setText("If you are from organisation team!");



        event1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myintent = new Intent(Mainpage.this,event1.class);
                startActivity(myintent);
            }
        });

        event2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(Mainpage.this,event2.class);
                startActivity(myintent);
            }
        });

        event3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(Mainpage.this,event3.class);
                startActivity(myintent);
            }
        });

        event4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(Mainpage.this,event4.class);
                startActivity(myintent);
            }
        });
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             Intent myintent = new Intent(Mainpage.this,signinnew.class);
             startActivity(myintent);

                /*
                final String User_Email = UserEmail.getText().toString();
                final String User_Password = UserPassword.getText().toString();

                if(User_Email.isEmpty())
                {
                    UserEmail.setError("Email is required");
                    UserEmail.requestFocus();
                    return;
                }


                if(!Patterns.EMAIL_ADDRESS.matcher(User_Email).matches())
                {
                    UserEmail.setError("Please enter a valid email");
                    UserEmail.requestFocus();

                }
                if(User_Password.isEmpty())
                {
                    UserPassword.setError("Password is required");
                    UserPassword.requestFocus();

                }

                if(UserPassword.length() < 6)
                {
                    UserPassword.setError("Minimum length of Password should be 6");
                    UserPassword.requestFocus();
                }

                progressbar.setVisibility(View.VISIBLE);

                firebaseAuth.signInWithEmailAndPassword(User_Email,User_Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressbar.setVisibility(View.GONE);
                        if(task.isSuccessful())
                        {

                            Intent go = new Intent(Mainpage.this,admininfoactivity.class);
                            go.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(go);
                        }else
                        {
                            Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                }); */


            }
        });


       /* SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(Mainpage.this,signup.class);
                startActivity(myIntent);

            }
        });
        */


    }



}
