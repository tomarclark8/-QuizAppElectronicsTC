package edu.bpi.quizappelectronicstc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LvlTwo extends AppCompatActivity {

    TextView qnumindex2;
    TextView questionsindex2;
    Button True;
    Button False;

private int lvlIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_level_two);

        qnumindex2 = (TextView) findViewById(R.id.qnumindex2);
        questionsindex2 = (TextView) findViewById(R.id.questionsindex2);
        True = (Button) findViewById(R.id.True);
        False = (Button) findViewById(R.id.False);

        //intent for score to check if min/ max correct
        Intent receivedIntent = getIntent();
        lvlIndicator = receivedIntent.getIntExtra("lvlIndicator", 2);



        //Buttons
        True.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playing the game
                //
                Intent intent = new Intent(LvlTwo.this, TransitionScreen.class);
                intent.putExtra("lvlIndicator", lvlIndicator);
                startActivity(intent);
            }
        });

        False.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playing the game
                Intent intent = new Intent(LvlTwo.this, TransitionScreen.class);
                intent.putExtra("lvlIndicator", lvlIndicator);
                startActivity(intent);
            }
        });
    }
}