package edu.bpi.quizappelectronicstc;

import android.annotation.SuppressLint;
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

        Score1.setText(MainQuestions.true_score());
        Score2.setText(MainQuestions.false_score());
        Scorewl.setText(MainQuestions.winner_score());


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