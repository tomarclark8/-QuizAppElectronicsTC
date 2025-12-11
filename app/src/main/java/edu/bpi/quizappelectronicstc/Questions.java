package edu.bpi.quizappelectronicstc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

//implement old questions
public class Questions {
String[] questionsone;
String[] questionstwo;
String[] questionsthree;
    String[] hintOne;
    String[] hintTwo;
    String[] hintThree;
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
        this.questionstwo = new String[]{
                "Is a red-red-blue-gold resistor nominal value greater than 45M-ohms?",
                "This the schematic symbol of a bulb?",
                "Conventional Current flows from Negative(-) to Positive(+)?",
                "Ohm's Law is represented by the equation V=(I)(R)?",
                "Make up something here lol"};
        this.questionsthree = new String[]{
                "Is a red-red-blue-gold resistor nominal value greater than 45M-ohms?",
                "This the schematic symbol of a bulb?",
                "Conventional Current flows from Negative(-) to Positive(+)?",
                "Ohm's Law is represented by the equation V=(I)(R)?",
                "Make up something here lol"};

        this.hintOne = new String[]{"hint one"};
        this.hintTwo = new String[]{"hint two"};
        this.hintThree = new String[]{"hint three"};

        //answers one
        this.answerone = new ArrayList<>();
        answerone.add(false);
        answerone.add(true);
        answerone.add(false);
        answerone.add(true);
        answerone.add(true);
        //answers two
        this.answertwo = new ArrayList<>();
        answertwo.add(false);
        answertwo.add(true);
        answertwo.add(false);
        answertwo.add(true);
        answertwo.add(true);
        //answers three
        this.answerthree = new ArrayList<>();
        answerthree.add(false);
        answerthree.add(true);
        answerthree.add(false);
        answerthree.add(true);
        answerthree.add(true);



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
        //Hints
        public String[] getlvlOneHints(){
        return hintOne;
        }
    public String[] getlvlTwoHints(){
        return hintTwo;
    }
    public String[] getlvlThreeHints(){
        return hintThree;
    }
}


    //,"false",, "true",,"false",,"true",,"false"));

