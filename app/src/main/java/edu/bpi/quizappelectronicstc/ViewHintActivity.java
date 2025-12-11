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

public class ViewHintActivity extends AppCompatActivity {
    TextView hintText;
    TextView answerText;
    Button backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_hint);


        hintText = findViewById(R.id.hintText);
        answerText = findViewById(R.id.answerText);
        backButton = findViewById(R.id.backButton);


        Intent intent = getIntent();
        String hint = intent.getStringExtra("hint");
        boolean answer = intent.getBooleanExtra("answer", true);




        hintText.setText(hint);
        answerText.setText(getString(R.string.answer_label) + " " +
                (answer ? getString(R.string.answer_true) : getString(R.string.answer_false)));

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Go back to question
            }
        });
    }
}