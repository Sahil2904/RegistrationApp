package com.example.sahil.registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class event3 extends AppCompatActivity {


    private TextView event3;
    private TextView head3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event3);

        event3 = (TextView)findViewById(R.id.tvev3);
        head3 = (TextView)findViewById(R.id.tvhead3);

        head3.setText("GAME STORM – (GAMING)");

        StringBuilder stringBuilder = new StringBuilder();

        String info = "Rules:\n" +
                "1. All participants must possess the participation fee receipt during the                event.\n" +
                "2. All participants must have their respective I.D. cards during the event.\n" +
                "3. On the spot registration and re-registration is allowed for PUBG only          on  the first day of the event.\n" +
                "4. All participants must reach on time of the event.\n" +
                "5. Number of gaming rounds will be decided on the number of entries.\n" +
                "\n" +
                "GAMES:\n" +
                "\n" +
                "\n" +
                "1. PUBG\n" +
                "2. Counter Strike version 1.6(Team of 5)\n" +
                "\n" +
                "Registration Fees:\n" +
                "\n" +
                "1. PUBG (Single Rs.70/-,Duo Rs.100/-,Squad Rs.200/-)\n" +
                "2. Counter Strike Rs.200/- per team.\n"
                + "For Registration contact: Shantanu\n" + "Mobile no: 7417418485" +"\n";

        stringBuilder.append(info);

        event3.setText(stringBuilder.toString());
    }
}
