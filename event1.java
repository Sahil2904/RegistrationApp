package com.example.sahil.registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class event1 extends AppCompatActivity {

    private TextView event1;
    private TextView head1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event1);

        event1 = (TextView)findViewById(R.id.tvev1);

        head1 = (TextView)findViewById(R.id.tvhead2);

        head1.setText(" CODEHUNT\n");

        StringBuilder stringBuilder = new StringBuilder();

        String info = " Coding :\n" +
                "•\tC/C++\n" +
                "•\tJava\n" +
                "•\tPython\n" +
                "•\tIt’s like a treasure hunt where the participants will have to solve the gven problem statement and code through it to get a particular outputs which leads them closer to their treasure.\n" +
                "•\tRounds to qualify are as follow:\n" +
                "o\tFirst round – This is a simple coding event where the students will have to code the given problem statement.\n" +
                "o\tSecond round – It’s a treasure hunt like round where the participants will have to solve the codes and get the outputs in order to get the clue to move forward.\n" +
                "\n" +
                "NOTE: Any of the following language can be selected (C, C++, JAVA, Python).\n" +
                "Common Question will be given irrespective of the language.\n" +
                " \n" + "For Registration contact: Kuldeep\n" + "Mobile no: 7417418455" +"\n";

        stringBuilder.append(info);

        event1.setText(stringBuilder.toString());


    }


}
