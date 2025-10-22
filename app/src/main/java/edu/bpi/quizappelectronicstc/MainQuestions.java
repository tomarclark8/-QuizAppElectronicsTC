package edu.bpi.quizappelectronicstc;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.Arrays;


public class MainQuestions extends AppCompatActivity {

    private int qindex = 0;
    private int qnum=1;
     static int tscore=0;
     static int fscore=0;
    private int anindex=1;

    TextView QuestioN;
    TextView Questions;
    Button True;
    Button False;

    //use for end-game class
    public static String true_score(){
        String score = ""+tscore;
        return score;
   }
    //use for end-game class
    public static String false_score(){
        String score = ""+fscore;
        return score;
   }

   //say who is the winnner


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_questions);


        QuestioN = (TextView) findViewById(R.id.QuestioN);
        Questions = (TextView) findViewById(R.id.Questions);
        True = (Button) findViewById(R.id.True);
        False = (Button) findViewById(R.id.False);


        //set of questions limit of 5
        // index of 10, 0-9
        // questions are 0-even
        // answers are 1-odd
        ArrayList<String> qlist  = new ArrayList<>(Arrays.asList("Is a red-red-blue-gold resistor nominal value greater than 45M-ohms?","false","This the schematic symbol of a bulb?", "true","Conventional Current flows from Negative(-) to Positive(+)?","false","Ohm's Law is represented by the equation V=(I)(R)?","true","Make up something here lol","false"));

        //set first question
        Questions.setText(qlist.get(qindex));



        True.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playing the game


                //switch to finishing game
                if(qlist.get(anindex).equalsIgnoreCase("true")) {
                    tscore++;
                } else {
                    fscore++;
                }
                anindex+= 2;
                qindex+= 2;
                qnum++;
                QuestioN.setText("Question #"+ qnum);
                Questions.setText(qlist.get(qindex));

                if(qnum == 5){
                    //intent to end of the game
                    Intent intent = new Intent(MainQuestions.this, MainEndGame.class);
                    startActivity(intent);
                }

            }
        });


        False.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //playing the game

                //switch to finishing game
                if(qlist.get(anindex).equalsIgnoreCase("false")) {
                    tscore++;
                } else {
                    fscore++;
                }
                anindex+= 2;
                qindex+= 2;
                qnum++;
                QuestioN.setText("Question #"+ qnum);
                Questions.setText(qlist.get(qindex));

                if(qnum == 5){
                    //intent to end of the game
                    Intent intent = new Intent(MainQuestions.this, MainEndGame.class);
                    startActivity(intent);
                }

            }
        });
    }
}
