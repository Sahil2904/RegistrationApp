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

public class signinnew extends AppCompatActivity {

    private EditText UserEmail;
    private EditText UserPassword;
   // private TextView Info;
    private Button SignIn;
    private FirebaseAuth firebaseAuth;
    private ProgressBar progressbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signinnew);


        firebaseAuth = FirebaseAuth.getInstance();
        UserEmail = (EditText)findViewById(R.id.etusrEmail);
        UserPassword = (EditText)findViewById(R.id.etPassword);
        //Info = (TextView) findViewById(R.id.tvinfo);
        SignIn = (Button)findViewById(R.id.btnSignin);
        //SignUp = (Button)findViewById(R.id.btnSignup);

        progressbar = (ProgressBar)findViewById(R.id.progressbar2);


        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                if(UserEmail.length() > 30)
                {
                    UserEmail.setError("Maximum Length of Email should is 30");
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
                if(UserPassword.length() > 15)
                {
                    UserPassword.setError("Maximum length of the password should be 15");
                    UserPassword.requestFocus();
                }

                progressbar.setVisibility(View.VISIBLE);

                firebaseAuth.signInWithEmailAndPassword(User_Email,User_Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressbar.setVisibility(View.GONE);
                        if(task.isSuccessful())
                        {

                            Intent go = new Intent(signinnew.this,admininfoactivity.class);
                            go.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(go);
                        }else
                        {
                            Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });


      /*  SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(signinnew.this,signup.class);
                startActivity(myIntent);

            }
        });
        */


    }

}
