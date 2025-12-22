package edu.bpi.quizappelectronicstc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TransitionScreen extends AppCompatActivity {
Button nextLvl;
TextView Level;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_transition_screen);

        nextLvl = (Button) findViewById(R.id.nextLvl);
        Level = (TextView) findViewById(R.id.Level);


        Intent intent = getIntent();
        int lvlIndicator = intent.getIntExtra("lvlIndicator", 0);
        int tscore1 = intent.getIntExtra("score1", 0);
        int tscore2 = intent.getIntExtra("score2", 0);
        int tscore3 = intent.getIntExtra("score3", 0);
        int scoreCounter = intent.getIntExtra("scoreCounter", 0);

        //Level 1 Indicator
        if(lvlIndicator == 1) {
            Level.setText("Level #"+lvlIndicator);
        }
        //Level 2 Indicator
        if(lvlIndicator == 2) {
            Level.setText("Level #"+lvlIndicator);
        }
        //Level 3 Indicator
        if(lvlIndicator == 3){
            Level.setText("Level #"+lvlIndicator);
        }
        if(lvlIndicator == 4) {
            Level.setText("Ready to See your Score?");
            nextLvl.setText("-> Click Here <-");
        }

        nextLvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

            Intent nextIntent;

            if(lvlIndicator == 1) {
                nextIntent = new Intent(TransitionScreen.this, LvlOne.class);
            } else if(lvlIndicator == 2) {
                nextIntent = new Intent(TransitionScreen.this, LvlTwo.class);
            } else if(lvlIndicator == 3) {
                nextIntent = new Intent(TransitionScreen.this, LvlThree.class);
            } else { // lvlIndicator == 4
                nextIntent = new Intent(TransitionScreen.this, EndGame.class);
            }

        // Always pass all scores you have
        nextIntent.putExtra("score1", tscore1);
        nextIntent.putExtra("score2", tscore2);
        nextIntent.putExtra("score3", tscore3);
        nextIntent.putExtra("lvlIndicator", lvlIndicator);
        nextIntent.putExtra("scoreCounter", scoreCounter);

        startActivity(nextIntent);

            }
        });
    }
}