package main.java.com.ceng431.G23_CENG431_HW1.Builder;

import main.java.com.ceng431.G23_CENG431_HW1.Entity.Quiz;
import main.java.com.ceng431.G23_CENG431_HW1.Entity.Unit;
import main.java.com.ceng431.G23_CENG431_HW1.Service.IQuizService;
import main.java.com.ceng431.G23_CENG431_HW1.Service.IRandomService;
import main.java.com.ceng431.G23_CENG431_HW1.Service.IUnitService;

import java.util.ArrayList;
import java.util.List;

public class UnitBuilder implements IUnitService {
    private final IQuizService quizService;
    private int MAX_QUIZ_COUNT = 10;
    private int MIN_QUIZ_COUNT = 1;

    public UnitBuilder(IQuizService quizService) {
        this.quizService = quizService;
    }

    public Unit createUnit(int unitNumber) {
        List<Quiz> quizzes = new ArrayList<>();
        IRandomService random = new RandomBuilder();
        int quizCount = random.createRandomInt(MAX_QUIZ_COUNT-MIN_QUIZ_COUNT) + MIN_QUIZ_COUNT;
        for (int quizNumber = 0; quizNumber < quizCount; quizNumber++) {
            quizzes.add(quizService.createQuiz(quizNumber + 1));
        }
        Unit unit = new Unit(unitNumber, quizzes);
        return unit;
    }
}
