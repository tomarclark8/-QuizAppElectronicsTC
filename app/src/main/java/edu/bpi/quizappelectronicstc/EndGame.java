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
    Button EmailScore;



    private int finalCorrect;
    private int finalWrong;
    private int totalQuestions;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_end_game);



        Correct = (TextView) findViewById(R.id.Score1);
        Wrong = (TextView) findViewById(R.id.Score2);
        Scorewl = (TextView) findViewById(R.id.scorewl);
        Again = (Button) findViewById(R.id.Again);
        EmailScore = findViewById(R.id.EmailScore);




        Intent intent = getIntent();
        int tscore1 = intent.getIntExtra("score1", 0);
        int tscore2 = intent.getIntExtra("score2", 0);
        int tscore3 = intent.getIntExtra("score3", 0);
        int lvlIndicator = intent.getIntExtra("lvlIndicator", 1);




        if(lvlIndicator < 4){
            if (lvlIndicator == 1) {
                // Correct or Wrong
                finalCorrect = tscore1;
                finalWrong = 5 - tscore1;
                totalQuestions = 5;
                Correct.setText("Correct: " + finalCorrect);
                Wrong.setText("Wrong: " + finalWrong);
                Scorewl.setText(getString(R.string.you_lose) + " " + getString(R.string.level_label) + " 1");
            }

            if (lvlIndicator == 2) {
                // Correct or Wrong
                finalCorrect = tscore1 + tscore2;
                finalWrong = 10 - finalCorrect;
                totalQuestions = 10;
                Correct.setText("Correct: " + (tscore2));
                Wrong.setText("Wrong: " + (5 - tscore2));
                Scorewl.setText(getString(R.string.you_lose) + " " + getString(R.string.level_label) + " 2");
            }

            if (lvlIndicator == 3) {
                // Correct or Wrong
                finalCorrect = tscore1 + tscore2 + tscore3;
                finalWrong = 15 - finalCorrect;
                totalQuestions = 15;
                Correct.setText("Correct: " + (tscore3));
                Wrong.setText("Wrong: " + (5 - tscore3));
                Scorewl.setText(getString(R.string.you_lose) + " " + getString(R.string.level_label) + " 3");
            }
        } else {
            if (lvlIndicator == 4) {
            finalCorrect = tscore1 + tscore2 + tscore3;
            finalWrong = 15 - finalCorrect;
            totalQuestions = 15;
            Correct.setText("Correct: " + (tscore1+tscore2+tscore3));
            Wrong.setText("Wrong: " + (15 -(tscore1+tscore2+tscore3)));
            Scorewl.setText(getString(R.string.congratulations));

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

        EmailScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendScoreEmail();
            }
        });
    }

    private void sendScoreEmail() {
        String subject = getString(R.string.email_subject);
        String body = getString(R.string.email_body_part1) + "\n\n" +
                getString(R.string.correct_label) + " " + finalCorrect + "\n" +
                getString(R.string.wrong_label) + " " + finalWrong + "\n" +
                getString(R.string.total_questions) + " " + 15 + "\n" +
                getString(R.string.percentage) + " " +
                String.format("%.1f%%", (finalCorrect * 100.0 / 15));

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, body);
        startActivity(emailIntent);
       //        startActivity(Intent.createChooser(emailIntent, getString(R.string.send_email)));
    }
}