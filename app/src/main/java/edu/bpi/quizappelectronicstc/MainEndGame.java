package edu.bpi.quizappelectronicstc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainEndGame extends AppCompatActivity {

    TextView Score1;
    TextView Score2;
    TextView woL;
    Button Again;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_end_game);

        Score1 = (TextView) findViewById(R.id.Score1);
        Score2 = (TextView) findViewById(R.id.Score2);
        woL = (TextView) findViewById(R.id.winorlose);
        Again = (Button) findViewById(R.id.Again);

        Score1.setText(MainQuestions.true_score());
        Score2.setText(MainQuestions.false_score());
        // check if score 1 >=3, check if score 2 >=3

        if(Score1.equals("3")){
            woL.setText("You WIN!!");
        }
        if(Score1.equals("4")){
            woL.setText("You WIN!!");
        }
        if(Score1.equals("5")){
            woL.setText("You WIN!!");
        }
        //losing condition-----
        if(Score2.equals("3")){
            woL.setText("You LOSE!!");
        }
        if(Score2.equals("4")){
            woL.setText("You LOSE!!");
        }
        if(Score2.equals("5")){
            woL.setText("You LOSE!!");
        }


        Again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //on click switch to main questions class
                Intent intent = new Intent(MainEndGame.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}