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

public class LvlTwo extends AppCompatActivity {

    TextView qnumindex2;
    TextView questions2;
    Button True;
    Button False;
    //private int lvlIndicator;
    private int tscore2;
    private int currentQuestion;
    private int questionIndex = 1;
    Questions questions = new Questions();
    String[] questionArray= questions.getlvlTwoQuestions();
    ArrayList<Boolean> answersArray = questions.getlvlTwoAnswer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_level_two);

        qnumindex2 = (TextView) findViewById(R.id.qnumindex2);
        questions2 = (TextView) findViewById(R.id.questions2);
        True = (Button) findViewById(R.id.True);
        False = (Button) findViewById(R.id.False);

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
            tscore2++;
        } else {
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
        }

        // Move to next question
        currentQuestion++;
        questionIndex++;

        // Check if there are more questions
        if(currentQuestion < questionArray.length) {
            // Display next question
            qnumindex2.setText("Question #"+questionIndex);
            questions2.setText(questionArray[currentQuestion]);
        } else if(tscore2 >= questionArray.length-1){
            // All questions answered, go to transition screen
            finishLevel();
        } else {
            endGame();
        }
    }
    private void finishLevel(){
        Intent intent = new Intent(LvlTwo.this, LvlThree.class);// transition
        intent.putExtra("score2", tscore2);
        intent.putExtra("lvlIndicator", 3);
        startActivity(intent);
    }
    private void endGame(){
        Intent intent = new Intent(LvlTwo.this, EndGame.class);
        intent.putExtra("score2", tscore2);
        intent.putExtra("lvlIndicator", 2);
        startActivity(intent);
    }
}