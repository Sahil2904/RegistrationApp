package com.example.sahil.registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class event6 extends AppCompatActivity {

    private TextView event;
    private Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event6);

        event = (TextView)findViewById(R.id.tvev6);

    }
}
