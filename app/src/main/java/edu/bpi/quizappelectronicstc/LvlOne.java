package edu.bpi.quizappelectronicstc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class LvlOne extends AppCompatActivity {

    TextView qnumindex1;
    TextView questions1;
    TextView scoreTextView;
    Button True;
    Button False;
    Button Hint;
    ImageView Bulb;

    private int tscore1;
    private int currentQuestion = 0;
    private int questionIndex = 1;
    private int scoreCounter = 0;

    // SharedPreferences
    private SharedPreferences mPreferences;
    private String sharedPrefFile = "edu.bpi.quizappelectronicstc";
    private final String TOP_SCORE_KEY = "TOP_SCORE";
    private final String USER_NAME_KEY = "USER_NAME";

    // Questions loaded from JSON
    private ArrayList<Question> questionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_level_one);

        qnumindex1 = (TextView) findViewById(R.id.qnumindex1);
        questions1 = (TextView) findViewById(R.id.questions1);
        scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        True = (Button) findViewById(R.id.True);
        False = (Button) findViewById(R.id.False);
        Hint = (Button) findViewById(R.id.Hint);
        Bulb = (ImageView) findViewById(R.id.bulb);

        scoreCounter = getIntent().getIntExtra("scoreCounter", 0);

        // Initialize SharedPreferences
        String sharedPrefFile = "edu.bpi.quizappelectronicstc";
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        // Load questions from JSON
        questionsList = new ArrayList<>();
        loadQuestionsFromJSON();

        // Sets 100% transparency
        Bulb.setAlpha(0.0f);

        // Initial Question Start
        if (questionsList.size() > 0) {
            questions1.setText(questionsList.get(currentQuestion).getPrompt());
        }

        // Display initial score
        updateScoreDisplay();

        // Buttons
        True.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        False.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

    private void loadQuestionsFromJSON() {
        try {
            // Read JSON file from assets folder
            InputStream is = getAssets().open("questions.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            String json = new String(buffer, "UTF-8");

            // Instantiation of JSON
            JSONObject jsonObject = new JSONObject(json);
            JSONArray questionsArray = jsonObject.getJSONArray("questionsone");

            // Load questions into ArrayList
            for (int i = 0; i < questionsArray.length(); i++) {
                JSONObject questionObj = questionsArray.getJSONObject(i);

                int id = questionObj.getInt("id");
                String prompt = questionObj.getString("prompt");
                boolean answer = questionObj.getBoolean("answer");
                String hint = questionObj.getString("hint");

                Question question = new Question(id, prompt, answer, hint);
                questionsList.add(question);
            }

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error loading questions", Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error parsing questions", Toast.LENGTH_SHORT).show();
        }
    }

    private void showHint() {
        Intent intent = new Intent(LvlOne.this, ViewHintActivity.class);
        intent.putExtra("hint", questionsList.get(currentQuestion).getHint());
        intent.putExtra("answer", questionsList.get(currentQuestion).getAnswer());
        startActivity(intent);
    }

    private void checkAnswer(boolean userAnswer) {
        // REQUIREMENT 1: Hide all buttons
        hideButtons();

        // Get the correct answer for current question
        boolean correctAnswer = questionsList.get(currentQuestion).getAnswer();

        // Check if user's answer is correct
        if(userAnswer == correctAnswer) {
            // REQUIREMENT 1: Tell user they were correct
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();

            // REQUIREMENT 2: Increment score counter
            scoreCounter++;
            tscore1++;

            // Check if new top score and save to SharedPreferences
            checkAndSaveTopScore();

        } else {
            // REQUIREMENT 1: Tell user they were incorrect
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();

            // REQUIREMENT 3: Reset score counter to 0
            scoreCounter = 0;
        }

        // Update score display
        updateScoreDisplay();

        // Move to next question
        currentQuestion++;
        questionIndex++;

        // Wait briefly before showing next question
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // REQUIREMENT 4: Present new question
                presentNextQuestion();
            }
        }, 1500);  // 1.5 second delay
    }

    private void hideButtons() {
        True.setVisibility(View.INVISIBLE);
        False.setVisibility(View.INVISIBLE);
        Hint.setVisibility(View.INVISIBLE);
    }

    private void showButtons() {
        True.setVisibility(View.VISIBLE);
        False.setVisibility(View.VISIBLE);
        Hint.setVisibility(View.VISIBLE);
    }

    private void presentNextQuestion() {
        // For question 2 specifically
        if(questionIndex == 2){
            Bulb.setAlpha(1.0f); // Sets 0% transparency
        } else {
            // Sets 100% transparency
            Bulb.setAlpha(0.0f);
        }

        // Check if there are more questions
        if(currentQuestion < questionsList.size()) {
            // Display next question
            qnumindex1.setText(getString(R.string.question_number) + questionIndex);
            questions1.setText(questionsList.get(currentQuestion).getPrompt());

            // Show buttons again for next question
            showButtons();

        } else if(tscore1 >= questionsList.size() - 1){
            // All questions answered, go to transition screen
            finishLevel();
        } else {
            endGame();
        }
    }

    private void checkAndSaveTopScore() {
        // Get current top score from SharedPreferences
        int currentTopScore = mPreferences.getInt(TOP_SCORE_KEY, 0);

        // If current score counter is greater than top score, save it
        if(scoreCounter > currentTopScore) {
            SharedPreferences.Editor editor = mPreferences.edit();
            editor.putInt(TOP_SCORE_KEY, scoreCounter);
            editor.apply();

            Toast.makeText(this, "New Top Score: " + scoreCounter + "!", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateScoreDisplay() {
        int topScore = mPreferences.getInt(TOP_SCORE_KEY, 0);
        scoreTextView.setText("Score: " + scoreCounter + " | Top Score: " + topScore);
    }

    private void finishLevel(){
        Intent intent = new Intent(LvlOne.this, TransitionScreen.class);
        intent.putExtra("score1", tscore1);
        intent.putExtra("scoreCounter", scoreCounter);
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