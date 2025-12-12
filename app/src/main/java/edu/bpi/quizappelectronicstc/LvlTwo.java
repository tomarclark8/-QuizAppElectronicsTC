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
    Button Hint;
    private int tscore2;
    private int currentQuestion;
    private int questionIndex = 1;


    Questions questions = new Questions();
    String[] questionArray= questions.getlvlTwoQuestions();
    ArrayList<Boolean> answersArray = questions.getlvlTwoAnswer();
    String[] hintsArray = questions.getlvlTwoHints();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_level_two);



        qnumindex2 = (TextView) findViewById(R.id.qnumindex2);
        questions2 = (TextView) findViewById(R.id.questions2);
        True = (Button) findViewById(R.id.True);
        False = (Button) findViewById(R.id.False);
        Hint = (Button) findViewById(R.id.Hint);



        //Initial Question Start
        questions2.setText(questionArray[currentQuestion]);



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
        Hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHint();
            }
        });
    }

    private void showHint() {
        Intent intent = new Intent(LvlTwo.this, ViewHintActivity.class);
        intent.putExtra("hint", hintsArray[currentQuestion]);
        intent.putExtra("answer", answersArray.get(currentQuestion));
        startActivity(intent);
    }
    private void checkAnswer(boolean userAnswer) {
        // Get the correct answer for current question
        boolean correctAnswer = answersArray.get(currentQuestion);

        // Check if user's answer is correct
        if(userAnswer == correctAnswer) {
            Toast.makeText(this, R.string.toast_correct, Toast.LENGTH_SHORT).show();
            tscore2++;
        } else {
            Toast.makeText(this, R.string.toast_wrong, Toast.LENGTH_SHORT).show();
        }

        // Move to next question
        currentQuestion++;
        questionIndex++;

        // Check if there are more questions
        if(currentQuestion < questionArray.length) {
            // Display next question
            qnumindex2.setText(getString(R.string.question_number)+(questionIndex+5));
            questions2.setText(questionArray[currentQuestion]);
        }else if(tscore2 >= questionArray.length-1){
            // All questions answered, go to transition screen
            finishLevel();
        } else {
            endGame();
        }
    }
    private void finishLevel(){
        Intent intent = new Intent(LvlTwo.this, TransitionScreen.class);// transition
        intent.putExtra("lvlIndicator", 3);
        intent.putExtra("score1", getIntent().getIntExtra("score1", 0));
        intent.putExtra("score2", tscore2);
        startActivity(intent);
    }
    private void endGame(){
        Intent intent = new Intent(LvlTwo.this, EndGame.class);
        intent.putExtra("lvlIndicator", 2);
        intent.putExtra("score1", getIntent().getIntExtra("score1", 0));
        intent.putExtra("score2", tscore2);
        startActivity(intent);
    }
}