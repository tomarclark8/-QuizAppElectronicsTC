package edu.bpi.quizappelectronicstc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class EndGame extends AppCompatActivity {

    TextView Correct;
    TextView Wrong;
    TextView Scorewl;
    Button Again;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_end_game);

        Correct = (TextView) findViewById(R.id.Score1);
        Wrong = (TextView) findViewById(R.id.Score2);
        Scorewl = (TextView) findViewById(R.id.scorewl);
        Again = (Button) findViewById(R.id.Again);

        Intent intent = getIntent();
        int tscore1 = intent.getIntExtra("score1", 1);
        int tscore2 = intent.getIntExtra("score2", 1);
        int tscore3 = intent.getIntExtra("score3", 1);
        int lvlIndicator = intent.getIntExtra("lvlIndicator", 1);


        if (lvlIndicator == 1) {
            Correct.setText("Correct: " + tscore1);
            Wrong.setText("Wrong: " + (5 - tscore1));
            if(tscore1 >= 4 ) {
                Scorewl.setText("You Winner!!" + 1);
            } else{
                Scorewl.setText("You Lose!!" + 1);
            }

        }

        if (lvlIndicator == 2) {
            Correct.setText("Correct: " + (tscore2 ));
            Wrong.setText("Wrong: " + (5 - tscore2));
            if(tscore2 >= 4 ) {
                Scorewl.setText("You Winner!!" + 2);
            } else{
                Scorewl.setText("You Lose!!" + 2);
            }
        }

        if (lvlIndicator >= 3) {
            Correct.setText("Correct: " + (tscore1+tscore2+tscore3));
            Wrong.setText("Wrong: " + (15 -(tscore1+tscore2+tscore3)));
            if(tscore3 >= 4 ) {
                Scorewl.setText("You Winner!!" + 4);
            } else{
                Scorewl.setText("You Lose!!" + 3);
            }

        }

        Again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //on click switch to main questions class
                Intent intent = new Intent(EndGame.this, StartGame.class);
                startActivity(intent);
            }
        });

    }
}