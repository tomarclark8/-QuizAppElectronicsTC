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

        //intent level indicator from classes
        Intent intent = getIntent();
        int lvlIndicator = intent.getIntExtra("lvlIndicator", 0);

        //connect xml and class
        nextLvl = (Button) findViewById(R.id.nextLvl);
        Level = (TextView) findViewById(R.id.Level);

        nextLvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //for intent to lvlone.class
                if(lvlIndicator == 0) {
                    Intent intent = getIntent();
                    int lvlIndicator = intent.getIntExtra("lvlIndicator", 1);

                    if(lvlIndicator == 1){
                        Intent intenttrans = new Intent(TransitionScreen.this, LvlOne.class);
                        startActivity(intenttrans);
                    }

                }
                //for intent to lvltwo.class
                if(lvlIndicator == 1) {
                    Intent intent = getIntent();
                    int lvlIndicator = intent.getIntExtra("lvlIndicator", 2);

                    if(lvlIndicator == 2) {
                        Intent intenttrans = new Intent(TransitionScreen.this, LvlTwo.class);
                        startActivity(intenttrans);
                    }
                }
                //for intent to lvlthree.class
                if(lvlIndicator == 2) {
                    Intent intent = getIntent();
                    int lvlIndicator = intent.getIntExtra("lvlIndicator", 3);

                    if(lvlIndicator == 3){
                        Intent intenttrans = new Intent(TransitionScreen.this, LvlThree.class);
                        startActivity(intenttrans);
                    }

                }

            }
        });
    }
}