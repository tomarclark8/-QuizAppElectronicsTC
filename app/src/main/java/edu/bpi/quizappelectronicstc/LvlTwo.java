package edu.bpi.quizappelectronicstc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
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

public class LvlTwo extends AppCompatActivity {

    TextView qnumindex2;
    TextView questions2;
    TextView scoreTextView;
    Button True;
    Button False;
    Button Hint;

    private int tscore2;
    private int currentQuestion = 0;
    private int questionIndex = 1;
    private int scoreCounter = 0;  // Current score counter

    // SharedPreferences
    private SharedPreferences mPreferences;
    private String sharedPrefFile = "edu.bpi.quizappelectronicstc";
    private final String TOP_SCORE_KEY = "TOP_SCORE_LVL2";

    // Questions loaded from JSON
    private ArrayList<Question> questionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_level_two);

        qnumindex2 = (TextView) findViewById(R.id.qnumindex2);
        questions2 = (TextView) findViewById(R.id.questions2);
        scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        True = (Button) findViewById(R.id.True);
        False = (Button) findViewById(R.id.False);
        Hint = (Button) findViewById(R.id.Hint);

        scoreCounter = getIntent().getIntExtra("scoreCounter", 0);

        // Initialize SharedPreferences
        String sharedPrefFile = "edu.bpi.quizappelectronicstc";
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        // Load questions from JSON
        questionsList = new ArrayList<>();
        loadQuestionsFromJSON();

        // Initial Question Start
        if (questionsList.size() > 0) {
            questions2.setText(questionsList.get(currentQuestion).getPrompt());
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

            // Parse JSON
            JSONObject jsonObject = new JSONObject(json);
            JSONArray questionsArray = jsonObject.getJSONArray("questionstwo");

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
        Intent intent = new Intent(LvlTwo.this, ViewHintActivity.class);
        intent.putExtra("hint", questionsList.get(currentQuestion).getHint());
        intent.putExtra("answer", questionsList.get(currentQuestion).getAnswer());
        startActivity(intent);
    }

    private void checkAnswer(boolean userAnswer) {
        // Hide all buttons
        hideButtons();

        // Get the correct answer for current question
        boolean correctAnswer = questionsList.get(currentQuestion).getAnswer();

        // Check if user's answer is correct
        if(userAnswer == correctAnswer) {
            Toast.makeText(this, R.string.toast_correct, Toast.LENGTH_SHORT).show();

            // Increment score counter
            scoreCounter++;
            tscore2++;

            // Check if new top score and save to SharedPreferences
            checkAndSaveTopScore();

        } else {
            Toast.makeText(this, R.string.toast_wrong, Toast.LENGTH_SHORT).show();

            // Reset score counter to 0
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
        // Check if there are more questions
        if(currentQuestion < questionsList.size()) {
            // Display next question
            qnumindex2.setText(getString(R.string.question_number) + (questionIndex + 5));
            questions2.setText(questionsList.get(currentQuestion).getPrompt());

            // Show buttons again for next question
            showButtons();

        } else if(tscore2 >= questionsList.size() - 1){
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
        Intent intent = new Intent(LvlTwo.this, TransitionScreen.class);
        intent.putExtra("lvlIndicator", 3);
        intent.putExtra("score1", getIntent().getIntExtra("score1", 0));
        intent.putExtra("score2", tscore2);
        intent.putExtra("scoreCounter", scoreCounter);
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