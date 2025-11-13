package edu.bpi.quizappelectronicstc;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class StartGame extends AppCompatActivity {
    TextView Title;
    Button Start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Title = (TextView) findViewById(R.id.MenuTitle);
        Start = (Button) findViewById(R.id.Startgame);

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //on click switch to mainquestions class
                Intent intent = new Intent(StartGame.this, LvlOne.class);
                startActivity(intent);


            }
        });






    }
}
