package edu.bpi.quizappelectronicstc;

import java.util.ArrayList;
import java.util.Arrays;

//implement old questions
public class Questions {

    public Questions(String q, String a){
        String[] questionsone = new String[]{
                "Is a red-red-blue-gold resistor nominal value greater than 45M-ohms?",
                "This the schematic symbol of a bulb?",
                "Conventional Current flows from Negative(-) to Positive(+)?",
                "Ohm's Law is represented by the equation V=(I)(R)?",
                "Make up something here lol"};
        String[] questionstwo = new String[]{};
        String[] questionsthree = new String[]{};


        ArrayList<String> answersone = new ArrayList<>(5);
        for(int i=0; i < questionsone.length + 1; i++){
            if(i % 2 == 0 || i == 0){
                answersone.add("true");
            }
            if(i % 2 > 0){
                answersone.add("false");
            }
        }

        //
        ArrayList<String> answerstwo = new ArrayList<>(3);
        for(int i=0; i < questionstwo.length + 1; i++){
            if(i % 2 == 0 || i == 0){
                answersone.add("true");
            }
            if(i % 2 > 0){
                answersone.add("false");
            }
        }

        //
        ArrayList<String> answersthree = new ArrayList<>(1);
        answersthree.add("true");


    }


    //,"false",, "true",,"false",,"true",,"false"));

}
