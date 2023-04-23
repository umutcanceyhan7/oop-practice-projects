package main.java.com.ceng431.G23_CENG431_HW1.Entity;

public class ListeningQuestion extends Question {
    private String chosenLanguage;
    private Audio audio;

    public ListeningQuestion(String chosenLanguage, Audio audio) {
        super();
        this.chosenLanguage = chosenLanguage;
        this.audio = audio;
    }
    @Override
    public int getPoints() {
        return 7;
    }

    @Override
    public String getQuestionType(){
        return "L";
    }

    @Override
    public String toString() {
        return "ListeningQuestion{" +
                "chosenLanguage='" + chosenLanguage + '\'' +
                ", audio=" + audio + super.toString() +
                '}';
    }
}
