package edu.bpi.quizappelectronicstc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPreference extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private String sharedPrefFile = "edu.bpi.quizappelectronicstc";
    private final String NAME_KEY = "USER_NAME";
    private final String TOP_SCORE_KEY = "TOP_SCORE";

    private EditText nameEditText;
    private TextView topScoreTextView;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared_preference);

        // Initialize views
        nameEditText = findViewById(R.id.nameEditText);
        topScoreTextView = findViewById(R.id.topScoreTextView);
        saveButton = findViewById(R.id.saveButton);

        // Initialize shared preferences
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        // Load saved name
        String savedName = mPreferences.getString(NAME_KEY, "");
        nameEditText.setText(savedName);

        // Load and display top score
        int topScore = mPreferences.getInt(TOP_SCORE_KEY, 0);
        topScoreTextView.setText("Top Score: " + topScore);

        // Save button click listener
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveName();
            }
        });
    }

    private void saveName() {
        // Get the entered name
        String userName = nameEditText.getText().toString();

        // Create editor object
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();

        // Save the name using putString()
        preferencesEditor.putString(NAME_KEY, userName);

        // Commit the changes
        preferencesEditor.apply();
    }

    // Call this method when you need to save a new top score
    public void saveTopScore(int score) {
        int currentTopScore = mPreferences.getInt(TOP_SCORE_KEY, 0);

        // Only save if new score is higher
        if (score > currentTopScore) {
            SharedPreferences.Editor preferencesEditor = mPreferences.edit();
            preferencesEditor.putInt(TOP_SCORE_KEY, score);
            preferencesEditor.apply();

            // Update display
            topScoreTextView.setText("Top Score: " + score);
        }
    }
}