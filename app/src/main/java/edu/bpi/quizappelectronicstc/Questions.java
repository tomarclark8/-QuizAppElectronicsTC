package edu.bpi.quizappelectronicstc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

//implement old questions
public class Questions {
String[] questionsone;
String[] questionstwo;
String[] questionsthree;
    ArrayList<Boolean> answerone;
    ArrayList<Boolean> answertwo;
    ArrayList<Boolean> answerthree;
    public Questions(){
        this.questionsone = new String[]{
                "Is a red-red-blue-gold resistor nominal value greater than 45M-ohms?",
                "This the schematic symbol of a bulb?",
                "Conventional Current flows from Negative(-) to Positive(+)?",
                "Ohm's Law is represented by the equation V=(I)(R)?",
                "Make up something here lol"};
        this.questionstwo = new String[3];
        this.questionsthree = new String[1];
        //answers one
        this.answerone = new ArrayList<>();
        answerone.add(false);
        answerone.add(true);
        answerone.add(false);
        answerone.add(true);
        answerone.add(true);
        //answers two
        this.answertwo = new ArrayList<>();
        answerone.add(false);
        answerone.add(true);
        answerone.add(false);
        answerone.add(true);
        answerone.add(true);
        //answers three
        this.answerthree = new ArrayList<>();
        answerone.add(false);
        answerone.add(true);
        answerone.add(false);
        answerone.add(true);
        answerone.add(true);



    }
        //Questions
        public String[] getlvlOneQuestions(){
            return questionsone;
        }
        public String[] getlvlTwoQuestions(){
            return questionstwo;
        }
        public String[] getlvlThreeQuestions(){
            return questionsthree;
        }
        //Answers
        public ArrayList<Boolean> getlvlOneAnswer(){
        return answerone;
        }
        public ArrayList<Boolean> getlvlTwoAnswer(){
            return answertwo;
        }
        public ArrayList<Boolean> getlvlThreeAnswer(){
            return answerthree;
        }
}


    //,"false",, "true",,"false",,"true",,"false"));

