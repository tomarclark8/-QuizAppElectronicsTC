package edu.bpi.quizappelectronicstc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.Arrays;

public class LvlOne extends AppCompatActivity {

    TextView qnumindex1;
    TextView questionsindex1;
    Button True;
    Button False;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_level_one);

        qnumindex1 = (TextView) findViewById(R.id.qnumindex1);
        questionsindex1 = (TextView) findViewById(R.id.questionsindex1);
        True = (Button) findViewById(R.id.True);
        False = (Button) findViewById(R.id.False);


        //intent for score to check if min/ max correct




        //Buttons
        True.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playing the game
                //
                Intent intent = new Intent(LvlOne.this, TransitionScreen.class);
                startActivity(intent);
            }
        });

        False.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playing the game
                Intent intent = new Intent(LvlOne.this, TransitionScreen.class);
                startActivity(intent);
            }
        });
    }
}
//ArrayList<String> qlist  = new ArrayList<>(Arrays.asList("Is a red-red-blue-gold resistor nominal value greater than 45M-ohms?","false","This the schematic symbol of a bulb?", "true","Conventional Current flows from Negative(-) to Positive(+)?","false","Ohm's Law is represented by the equation V=(I)(R)?","true","Make up something here lol","false"));
