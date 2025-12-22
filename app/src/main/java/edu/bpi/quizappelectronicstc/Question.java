package edu.bpi.quizappelectronicstc;

public class Question {
    private int id;
    private String prompt;
    private boolean answer;
    private String hint;

    public Question(int id, String prompt, boolean answer, String hint) {
        this.id = id;
        this.prompt = prompt;
        this.answer = answer;
        this.hint = hint;
    }

    public int getId() {
        return id;
    }

    public String getPrompt() {
        return prompt;
    }

    public boolean getAnswer() {
        return answer;
    }

    public String getHint() {
        return hint;
    }
}
