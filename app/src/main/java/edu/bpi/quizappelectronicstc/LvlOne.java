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
    Button Hint;
    private int tscore1;
    private int currentQuestion;
    private int questionIndex = 1;

    Questions questions = new Questions();
    String[] questionArray= questions.getlvlOneQuestions();
    ArrayList<Boolean> answersArray = questions.getlvlOneAnswer();
    String[] hintsArray = questions.getlvlOneHints();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_level_one);

        qnumindex1 = (TextView) findViewById(R.id.qnumindex1);
        questions1 = (TextView) findViewById(R.id.questions1);
        True = (Button) findViewById(R.id.True);
        False = (Button) findViewById(R.id.False);
        Hint = (Button) findViewById(R.id.Hint);
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
        Hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHint();
            }
        });
    }

    private void showHint() {
        Intent intent = new Intent(LvlOne.this, ViewHintActivity.class);
        intent.putExtra("hint", hintsArray[currentQuestion]);
        intent.putExtra("answer", answersArray.get(currentQuestion));
        startActivity(intent);
    }
    private void checkAnswer(boolean userAnswer) {
        // Get the correct answer for current question
        boolean correctAnswer = answersArray.get(currentQuestion);

        // Check if user's answer is correct
        if(userAnswer == correctAnswer) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            tscore1++;
        } else {
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
        }

        // Move to next question
        currentQuestion++;
        questionIndex++;

        // Check if there are more questions
        if(currentQuestion < questionArray.length) {
            // Display next question
            qnumindex1.setText(getString(R.string.question_number)+questionIndex);
            questions1.setText(questionArray[currentQuestion]);

        } else if(tscore1 >= questionArray.length-1){
            // All questions answered, go to transition screen
            finishLevel();
        } else {
            endGame();
        }
    }
    private void finishLevel(){
        Intent intent = new Intent(LvlOne.this, TransitionScreen.class);
        intent.putExtra("score1", tscore1);
        intent.putExtra("lvlIndicator",2);
        startActivity(intent);
    }
    private void endGame(){
        Intent intent = new Intent(LvlOne.this, EndGame.class);
        intent.putExtra("score1", tscore1);
        intent.putExtra("lvlIndicator", 1);
        startActivity(intent);
    }

}
//ArrayList<String> qlist  = new ArrayList<>(Arrays.asList("Is a red-red-blue-gold resistor nominal value greater than 45M-ohms?","false","This the schematic symbol of a bulb?", "true","Conventional Current flows from Negative(-) to Positive(+)?","false","Ohm's Law is represented by the equation V=(I)(R)?","true","Make up something here lol","false"));
