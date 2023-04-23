package main.java.com.ceng431.G23_CENG431_HW1.Entity;

public class ReadingQuestion extends Question {
    private String english;
    private String chosenLanguage;

    public ReadingQuestion(String english, String chosenLanguage) {
        super();
        this.english = english;
        this.chosenLanguage = chosenLanguage;
    }

    @Override
    public int getPoints() {
        return 10;
    }

    @Override
    public String getQuestionType(){
        return "R";
    }

    @Override
    public String toString() {
        return "ReadingQuestion{" +
                "english='" + english + '\'' +
                ", chosenLanguage='" + chosenLanguage + '\'' +
                super.toString() + '}';
    }
}
