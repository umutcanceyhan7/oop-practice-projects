package main.java.com.ceng431.G23_CENG431_HW1.Entity;

import java.util.Map;
public class WordMatchingQuestion extends Question {
    private Map<String, String> wordMatchingList;

    public WordMatchingQuestion(Map<String, String> wordMatchingList) {
        super();
        this.wordMatchingList = wordMatchingList;
    }

    @Override
    public int getPoints() {
        return 5;
    }

    @Override
    public String getQuestionType(){
        return "W";
    }

    @Override
    public String toString() {
        return "WordMatchingQuestion{" +
                "wordMatchingList=" + wordMatchingList +
                super.toString() + '}';
    }
}
