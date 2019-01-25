package com.example.sahil.registration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class admininfoactivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Toolbar toolbar;
    private Button event1;
    private Button event2;
    private Button event3;
    private Button event4;
    private Button reg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infoactivity);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        event1 = (Button)findViewById(R.id.btnin1);
        event2 = (Button)findViewById(R.id.btnin2);
        event3 = (Button)findViewById(R.id.btnin3);
        event4 = (Button)findViewById(R.id.btnin4);
        reg = (Button)findViewById(R.id.btinreg);


        event1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myintent = new Intent(admininfoactivity.this,event1.class);
                startActivity(myintent);
            }
        });

        event2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(admininfoactivity.this,event2.class);
                startActivity(myintent);
            }
        });

        event3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(admininfoactivity.this,event3.class);
                startActivity(myintent);
            }
        });

        event4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(admininfoactivity.this,event4.class);
                startActivity(myintent);
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(admininfoactivity.this,userRegistraion.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menulogout:
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(admininfoactivity.this,Mainpage.class));
                break;


        }


        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
