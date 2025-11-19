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
    TextView questions1;
    Button True;
    Button False;
    private int lvlIndicator;
    private int score;
    private int currentQuestion;

    Questions questions = new Questions();
    String[] questionArray= questions.getlvlOneQuestions();
    ArrayList<Boolean> answersArray = questions.getlvlOneAnswer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_level_one);

        qnumindex1 = (TextView) findViewById(R.id.qnumindex1);
        questions1 = (TextView) findViewById(R.id.questions1);
        True = (Button) findViewById(R.id.True);
        False = (Button) findViewById(R.id.False);

        //intent for score to check if min/ max correct
        Intent receivedIntent = getIntent();
        lvlIndicator = receivedIntent.getIntExtra("lvlIndicator", 2);

        //Initial Question Start
        questions1.setText(questionArray[currentQuestion]);

        //Buttons
        True.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playing the game
                checkAnswer(true);
            }
        });

        False.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playing the game
                checkAnswer(false);
            }
        });
    }

    private void checkAnswer(boolean userAnswer) {
        // Get the correct answer for current question
        boolean correctAnswer = answersArray.get(currentQuestion);

        // Check if user's answer is correct
        if(userAnswer == correctAnswer) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            score++;
        } else {
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
        }

        // Move to next question
        currentQuestion++;

        // Check if there are more questions
        if(currentQuestion < questionArray.length) {
            // Display next question
            questions1.setText(questionArray[currentQuestion]);
        } else if(score >= questionArray.length-1){
            // All questions answered, go to transition screen
            finishLevel();
        } else {
            endGame();
        }
    }
    private void finishLevel(){
        Intent intent = new Intent(LvlOne.this, TransitionScreen.class);
        intent.putExtra("score", score);
        intent.putExtra("lvlIndicator", lvlIndicator);
        startActivity(intent);
    }
    private void endGame(){
        Intent intent = new Intent(LvlOne.this, EndGame.class);
        intent.putExtra("score", score);
        intent.putExtra("lvlIndicator", lvlIndicator);
        startActivity(intent);
    }

}
//ArrayList<String> qlist  = new ArrayList<>(Arrays.asList("Is a red-red-blue-gold resistor nominal value greater than 45M-ohms?","false","This the schematic symbol of a bulb?", "true","Conventional Current flows from Negative(-) to Positive(+)?","false","Ohm's Law is represented by the equation V=(I)(R)?","true","Make up something here lol","false"));
