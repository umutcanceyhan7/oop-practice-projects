package main.java.com.ceng431.G23_CENG431_HW1.Builder;

import main.java.com.ceng431.G23_CENG431_HW1.Entity.Question;
import main.java.com.ceng431.G23_CENG431_HW1.Entity.Quiz;
import main.java.com.ceng431.G23_CENG431_HW1.Service.IQuestionService;
import main.java.com.ceng431.G23_CENG431_HW1.Service.IQuizService;
import main.java.com.ceng431.G23_CENG431_HW1.Service.IRandomService;

import java.util.ArrayList;
import java.util.List;

public class QuizBuilder implements IQuizService {
    private IQuestionService questionService;
    private int MAX_QUESTION_COUNT = 15;
    private int MIN_QUESTION_COUNT = 8;

    public QuizBuilder(IQuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Quiz createQuiz(int quizNumber) {
        List<Question> questions = new ArrayList<>();
        IRandomService random = new RandomBuilder();
        int questionCount = random.createRandomInt(MAX_QUESTION_COUNT - MIN_QUESTION_COUNT) + MIN_QUESTION_COUNT;
        for (int questionNumber = 0; questionNumber < questionCount; questionNumber++) {
            questions.add(questionService.createQuestion(questionNumber + 1));
        }
        Quiz quiz = new Quiz(quizNumber, questions);
        return quiz;
    }
}
