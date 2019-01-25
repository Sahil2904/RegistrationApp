package com.example.sahil.registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class event4 extends AppCompatActivity {

    private TextView event;
    private TextView head4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event4);

        event = (TextView)findViewById(R.id.tvev4);
        head4 = (TextView)findViewById(R.id.tvhead4);

        head4.setText("PICASO");

        StringBuilder stringBuilder = new StringBuilder();
        String info = "Rules:\n" +
                "\n" +
                "•\tTopic will be given on spot.\n" +
                "•\tTime allowed for photography will be 1.15 hour.\n" +
                "•\tTime allowed for editing will be 30 min.\n" +
                "•\tThe following softwares will be provided by us : -\n" +
                "•\tPhotoshop cs6, Picaso , Lightroom cs6.\n" +
                "•\tParticipants are allowed to use their mobile editing softwares.\n" +
                "•\tThe best photo selected by the judges will be awarded the first prize.\n" +
                "•\tTeam of max. 2 members.\n" +
                "\n" +
                "Registration fees: \tRs. 50(single participant)\n" +
                "Rs.70(Team of 2)\n" +
                "\n"
                + "For Registration contact: Pratik\n" + "Mobile no: 7418518455" +"\n";

        stringBuilder.append(info);

        event.setText(stringBuilder.toString());


    }
}
