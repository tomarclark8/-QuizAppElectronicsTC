package edu.bpi.quizappelectronicstc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LvlTwo extends AppCompatActivity {

    TextView qnumindex2;
    TextView questionsindex2;
    Button True;
    Button False;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_level_two);

        //intents between start game, and end of the game for a few seconds
        //implement extra feature(gamble or bookmark using skip button
        //difficulty based on score[meet minimum score to move onto the next section])
        //if intent into difficlevl class true,
        //start timer and once timer meets 0seconds(index-1) or 2seconds(index+1)
        //intent again back to questions class.
    }
}