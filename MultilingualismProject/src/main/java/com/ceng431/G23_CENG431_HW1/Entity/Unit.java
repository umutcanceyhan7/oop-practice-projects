package main.java.com.ceng431.G23_CENG431_HW1.Entity;

import java.util.ArrayList;
import java.util.List;

public class Unit {
    private int unitNumber;
    private Language language;

    private List<Quiz> quizzes = new ArrayList<>();
    public Unit(int unitNumber, List<Quiz> quizzes) {
        this.unitNumber = unitNumber;
        this.quizzes=quizzes;
    }

    public int getUnitNumber() {
        return unitNumber;
    }
    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "unitNumber=" + unitNumber +
                ", language=" + language +
                ", quizzes=" + quizzes +
                '}';
    }

//    private void quizInitialization(Long unitId, int quizCount, List<String> questionTypes) {
//        // Get unit entity via id
//
//        for (int i = 0; i < quizCount; i++) {
//            Quiz tempQuiz = new Quiz();
//
//            // Assign unit to the corresponding language and save to DB
//            // assignQuizToUnit(tempQuiz.getId(), tempUnit.getId());
//
//
//        }
//    }
    // Create quizzes and assign them into the corresponding unit and save to DB.
    // CREATOR ÇAĞIRACAK quizInitialization(tempUnit.getId(), quizCount, questionTypes);

}
