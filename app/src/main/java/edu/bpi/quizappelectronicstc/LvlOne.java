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

    private int qindex = 0;
    private int qnum=1;
    static int tscore=0;
    static int fscore=0;
    private int anindex=1;

    TextView qnumindex1;
    TextView questionsindex1;
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
    public static String winner_score(){
        String winner="";
        if(fscore > tscore && fscore == 5 ){
            winner = "Your the LOSER!!";

        }
        if(tscore > fscore && tscore == 5 ){
            winner = "Your the WINNER!!";
        }
        return winner;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_level_one);


        qnumindex1 = (TextView) findViewById(R.id.qnumindex1);
        questionsindex1 = (TextView) findViewById(R.id.questionsindex1);
        True = (Button) findViewById(R.id.True);
        False = (Button) findViewById(R.id.False);


        //set of questions limit of 5
        // index of 10, 0-9
        // questions are 0-even
        // answers are 1-odd
        ArrayList<String> qlist  = new ArrayList<>(Arrays.asList("Is a red-red-blue-gold resistor nominal value greater than 45M-ohms?","false","This the schematic symbol of a bulb?", "true","Conventional Current flows from Negative(-) to Positive(+)?","false","Ohm's Law is represented by the equation V=(I)(R)?","true","Make up something here lol","false"));

        //set first question
        questionsindex1.setText(qlist.get(qindex));

        //Buttons
        True.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playing the game


                //switch to finishing game

                //statement for last question


                //fixed limit

                if(qindex <= 8 && anindex <= 9) {
                    if (qlist.get(anindex).equalsIgnoreCase("true")) {
                        tscore++;
                        Toast.makeText(LvlOne.this, "Correct!", Toast.LENGTH_SHORT).show();
                    } else {
                        fscore++;
                        Toast.makeText(LvlOne.this, "Wrong!", Toast.LENGTH_SHORT).show();
                    }
                    anindex += 2;
                    qindex += 2;
                    qnum++;
                    if (qnum == 6){
                        Intent intent = new Intent(LvlOne.this, EndGame.class);
                        startActivity(intent);
                    } else {
                        qnumindex1.setText("Question #" + qnum);
                        questionsindex1.setText(qlist.get(qindex));
                    }
                }

            }
        });

        False.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //playing the game

                //switch to finishing game
                if(qindex <= 8 && anindex <= 9) {
                    if (qlist.get(anindex).equalsIgnoreCase("false")) {
                        tscore++;
                        Toast.makeText(LvlOne.this, "Correct!", Toast.LENGTH_SHORT).show();
                    } else {
                        fscore++;
                        Toast.makeText(LvlOne.this, "Wrong!", Toast.LENGTH_SHORT).show();
                    }
                    anindex += 2;
                    qindex += 2;
                    qnum++;
                    if (qnum == 6){
                        Intent intent = new Intent(LvlOne.this, EndGame.class);
                        startActivity(intent);
                    } else {
                        qnumindex1.setText("Question #" + qnum);
                        questionsindex1.setText(qlist.get(qindex));
                    }
                }



            }
        });
    }
}
