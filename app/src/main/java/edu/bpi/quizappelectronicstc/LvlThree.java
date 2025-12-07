package edu.bpi.quizappelectronicstc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class LvlThree extends AppCompatActivity {

    TextView qnumindex3;
    TextView questions3;
    Button True;
    Button False;
    //private int lvlIndicator;
    private int tscore3;
    private int currentQuestion;
    private int questionIndex = 1;
    Questions questions = new Questions();
    String[] questionArray= questions.getlvlThreeQuestions();
    ArrayList<Boolean> answersArray = questions.getlvlThreeAnswer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_level_three);

        qnumindex3 = (TextView) findViewById(R.id.qnumindex3);
        questions3 = (TextView) findViewById(R.id.questions3);
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
            tscore3++;
        } else {
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
        }

        // Move to next question
        currentQuestion++;
        questionIndex++;

        // Check if there are more questions
        if(currentQuestion < questionArray.length) {
            // Display next question
            qnumindex3.setText("Question #"+questionIndex);
            questions3.setText(questionArray[currentQuestion]);

        } else if(tscore3 >= questionArray.length-1){
            // All questions answered, go to end screen
            endGame();
        }
    }
    private void endGame(){
        Intent intent = new Intent(LvlThree.this, EndGame.class);
        intent.putExtra("score3", tscore3);
        intent.putExtra("lvlIndicator", 3);
        startActivity(intent);
    }
}