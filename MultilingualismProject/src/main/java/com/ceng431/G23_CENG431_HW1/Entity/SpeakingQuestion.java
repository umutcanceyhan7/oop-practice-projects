package main.java.com.ceng431.G23_CENG431_HW1.Entity;

import java.util.ArrayList;
import java.util.List;

public class SpeakingQuestion extends Question {
    private List<Audio> audios = new ArrayList<>();

    public SpeakingQuestion(List<Audio> audios) {
        super();
        this.audios = audios;
    }

    @Override
    public int getPoints() {
        return 8;
    }

    @Override
    public String getQuestionType(){
        return "S";
    }

    @Override
    public String toString() {
        return "SpeakingQuestion{" +
                "audios=" + audios +
                '}' + super.toString();
    }
}
