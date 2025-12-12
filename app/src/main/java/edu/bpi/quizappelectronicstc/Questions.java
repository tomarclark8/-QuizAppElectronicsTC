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
                "Do Capacitors store energy in an electric field between plates?"};
        this.questionstwo = new String[]{
                "Does a diode allow current to flow in both directions?",
                "Is the unit of resistance called the Ohm?",
                "In a series circuit, current is the same at all points?",
                "Does an LED emit light when reverse biased?",
                "Is a transistor a three-terminal device?"};
        this.questionsthree = new String[]{
                "Does a short circuit have infinite resistance?",
                "In parallel circuits, voltage is the same across all branches?",
                "Is AC current the same as DC current?",
                "Does a fuse protect a circuit by opening when current is too high?",
                "Is power measured in Watts?"};



        this.hintOne = new String[]{
                "Red-Red-Blue means 22 followed by 6 zeros (22,000,000 ohms = 22M ohms)",
                "A bulb symbol has a circle with an X or filament inside",
                "Conventional current flows from positive to negative terminal",
                "Ohm's Law: Voltage = Current × Resistance",
                "Capacitors store energy in an electric field between plates"};
        this.hintTwo = new String[]{
                "Diodes are one-way gates for current flow",
                "Resistance is measured in Ohms (Ω), named after Georg Ohm",
                "In series circuits, the same current flows through all components",
                "LEDs only emit light when forward biased (current flows forward)",
                "Transistors have three terminals: base, collector, and emitter"};
        this.hintThree = new String[]{
                "A short circuit has almost zero resistance (direct connection)",
                "Parallel circuits share the same voltage across all branches",
                "AC alternates direction, DC flows in one direction only",
                "Fuses contain a wire that melts and breaks the circuit when overloaded",
                "Power is measured in Watts (W), calculated as P = V × I"};

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
        answertwo.add(true);
        answertwo.add(false);
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

