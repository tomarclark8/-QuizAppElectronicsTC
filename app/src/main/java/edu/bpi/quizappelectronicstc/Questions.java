package edu.bpi.quizappelectronicstc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

//implement old questions
public class Questions {
String[] questionsone;
String[] questionstwo;
String[] questionsthree;
    public Questions(String q, boolean a){
        this.questionsone = new String[]{
                "Is a red-red-blue-gold resistor nominal value greater than 45M-ohms?",
                "This the schematic symbol of a bulb?",
                "Conventional Current flows from Negative(-) to Positive(+)?",
                "Ohm's Law is represented by the equation V=(I)(R)?",
                "Make up something here lol"};
        this.questionstwo = new String[3];
        this.questionsthree = new String[1];
        ArrayList<String> answers  = new ArrayList<String>();



    }
        //Questions
        public String getlvlOneQuestions(int i){
            if(i > questionsone.length-1){
                return questionsone[3];
            }
            if(i < 0){
                return questionsone[0];
            }
            return questionsone[i];
        }
        public String getlvlTwoQuestions(int i){
            if(i > questionstwo.length-1){
                return questionstwo[3];
            }
            if(i < 0){
                return questionstwo[0];
            }
            return questionstwo[i];
        }
        public String getlvlThreeQuestions(int i){
            if(i != questionsthree.length-1){
                return questionsthree[0];
            }
            return questionsthree[i];
        }
        //Answers
        public String getlvlOneAnswer(){
        return "";
        }
        public String getlvlTwoAnswer(){
            return "";
        }
        public String getlvlThreeAnswer(){
            return "";
        }
}


    //,"false",, "true",,"false",,"true",,"false"));

