package main.java.com.ceng431.G23_CENG431_HW1.Service;

import main.java.com.ceng431.G23_CENG431_HW1.Entity.Question;

public interface IQuestionService {
    <T extends Question> Question createQuestion(int questionNumber);
}
