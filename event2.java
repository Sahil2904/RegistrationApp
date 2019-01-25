package com.example.sahil.registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class event2 extends AppCompatActivity {

    private TextView event2;
    private TextView head2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event2);

        event2 = (TextView)findViewById(R.id.tvev2);
        head2 = (TextView)findViewById(R.id.tvhead2);

        head2.setText("BRAINIAC\n");

        StringBuilder stringBuilder = new StringBuilder();

        String info = "\t Elimination round :-\n" +
                "•\tTotal 40 Multiple Choice Questions, including reasoning.\n" +
                "•\tTotal time :- 45 minutes.\n" +
                "\n" +
                "\tQualification round :-\n" +
                "•\tTotal 30 mcqs, including reasoning.\n" +
                "•\tTotal time: - 45 minutes.\n" +
                "\n" +
                "\t Group discussion :-\n" +
                "•\t10 members in each group.\n" +
                "•\tTotal time for each group: - 10 minutes.\n" +
                "•\tTopic for GD: - related to technical, current affair & social issue.\n" +
                "\n" +
                "\t Personal interview :-\n" +
                "•\tIt would be completely based on campus placement.\n" +
                "•\tFinal result will be decided by the judge.\n" +
                "•\tJudges decision will be the final decision.\n" + "\nRegistration Fees for Brainiac (Aptitude/GD/PI):Rs.50/-"
                +"\n" + "For Registration contact: Sahil\n" + "Mobile no: 7587418455" +"\n";

            stringBuilder.append(info);

        event2.setText(stringBuilder.toString());




    }
}
