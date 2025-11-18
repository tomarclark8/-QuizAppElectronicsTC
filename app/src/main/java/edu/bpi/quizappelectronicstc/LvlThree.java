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

public class LvlThree extends AppCompatActivity {

    TextView qnumindex3;
    TextView questionsindex3;
    Button True;
    Button False;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_level_three);

        qnumindex3 = (TextView) findViewById(R.id.qnumindex3);
        questionsindex3 = (TextView) findViewById(R.id.questionsindex3);
        True = (Button) findViewById(R.id.True);
        False = (Button) findViewById(R.id.False);

        //Buttons
        True.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playing the game
                //
                Intent intent = new Intent(LvlThree.this, TransitionScreen.class);
                startActivity(intent);
            }
        });

        False.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playing the game
                Intent intent = new Intent(LvlThree.this, TransitionScreen.class);
                startActivity(intent);
            }
        });
    }
}