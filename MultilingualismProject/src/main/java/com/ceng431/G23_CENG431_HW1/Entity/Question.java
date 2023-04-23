package main.java.com.ceng431.G23_CENG431_HW1.Entity;

public abstract class Question {
    private int points;
    private Quiz quiz;

    @Override
    public String toString() {
        return "Question{" +
                "points=" + getPoints() +
                ", quiz=" + quiz +
                '}';
    }

    public abstract int getPoints();
    public abstract String getQuestionType();
}
