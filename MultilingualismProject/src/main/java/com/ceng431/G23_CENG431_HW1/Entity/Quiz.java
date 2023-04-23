package main.java.com.ceng431.G23_CENG431_HW1.Entity;


import main.java.com.ceng431.G23_CENG431_HW1.MultilingualismApplication.QUESTION_TYPE;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private int quizNumber;
    private Unit unit;
    private List<Question> questions = new ArrayList<>();

    public Quiz(int quizNumber, List<Question> questions) {
        this.quizNumber = quizNumber;
        this.questions = questions;
    }

    public int getQuizNumber() {
        return quizNumber;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "quizNumber=" + quizNumber +
                ", unit=" + unit +
                ", questions=" + questions +
                '}';
    }
}
