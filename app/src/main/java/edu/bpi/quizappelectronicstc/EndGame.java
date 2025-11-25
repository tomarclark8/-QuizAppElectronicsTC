package edu.bpi.quizappelectronicstc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class EndGame extends AppCompatActivity {

    TextView Score1;
    TextView Score2;
    TextView Scorewl;
    Button Again;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_end_game);

        Score1 = (TextView) findViewById(R.id.Score1);
        Score2 = (TextView) findViewById(R.id.Score2);
        Scorewl = (TextView) findViewById(R.id.scorewl);
        Again = (Button) findViewById(R.id.Again);

        Intent intent = getIntent();
        int tscore1 = intent.getIntExtra("score1", 1);
        int tscore2 = intent.getIntExtra("score2", 1);
        int tscore3 = intent.getIntExtra("score3", 1);
        int lvlindicator = intent.getIntExtra("lvlindicator", 1);

        if (lvlindicator == 1) {
            Score1.setText("Correct: " + tscore1);
            Score2.setText("False: " + (5 - tscore1));

                if (tscore1 > (5 - tscore1) && tscore1 >= 4) {
                Scorewl.setText("You Won!!");
                } else {
                Scorewl.setText("You Lose!!");
                }

        if (lvlindicator == 2) {
            Score1.setText("Correct: " + tscore1 + tscore2);
            Score2.setText("False: " + (10 - tscore1 + tscore2));

            if ((tscore1+tscore2) > (10 - tscore1 + tscore2) && (tscore1+tscore2) >= 8) {
                Scorewl.setText("You Won!!");
            } else {
                Scorewl.setText("You Lose!!");
            }
        }

        if (lvlindicator == 3) {
            Score1.setText("Correct: " + tscore1 + tscore2 + tscore3);
            Score2.setText("False: " + (15 - tscore1 + tscore2 + tscore3));

            if ((tscore1 + tscore2 + tscore3) > (15 - (tscore1 + tscore2 + tscore3)) && (tscore1 + tscore2 + tscore3) >= 12) {
                Scorewl.setText("You Won!!");
            } else {
                Scorewl.setText("You Lose!!");
            }

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