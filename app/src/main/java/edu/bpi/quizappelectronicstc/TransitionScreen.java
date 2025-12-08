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
//connect xml and class
        nextLvl = (Button) findViewById(R.id.nextLvl);
        Level = (TextView) findViewById(R.id.Level);

        //intent level indicator from classes
        Intent intent = getIntent();
        int lvlIndicator = intent.getIntExtra("lvlIndicator", 1);
        Level.setText("Level #"+lvlIndicator);

        nextLvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //Intent for Level Indicator
                Intent intenttrans = new Intent();

                //Level 1 Indicator
                if(lvlIndicator == 1) {
                    Level.setText("Level #"+lvlIndicator);
                    intenttrans = new Intent(TransitionScreen.this, LvlOne.class);
                    intenttrans.putExtra("lvlIndicator", 2);
                    startActivity(intenttrans);
                }
                //Level 2 Indicator
                else if(lvlIndicator == 2) {
                    Level.setText("Level #"+lvlIndicator);
                    intenttrans = new Intent(TransitionScreen.this, LvlTwo.class);
                    intenttrans.putExtra("lvlIndicator", 3);
                    startActivity(intenttrans);
                }
                //Level 3 Indicator
                else if(lvlIndicator == 3){
                    Level.setText("Level #"+lvlIndicator);
                    intenttrans = new Intent(TransitionScreen.this, LvlThree.class);
                    intenttrans.putExtra("lvlIndicator", 4);
                    startActivity(intenttrans);
                }
                // End of Game Indicator
                else if(lvlIndicator == 4){
                    Level.setText("Ready to See your Score?");
                    nextLvl.setText("-> Click Here <-");
                    intenttrans = new Intent(TransitionScreen.this, EndGame.class);
                    intenttrans.putExtra("score1", 1);
                    intenttrans.putExtra("score2", 1);
                    intenttrans.putExtra("score3", 1);
                    startActivity(intenttrans);
                }

            }
        });
    }
}