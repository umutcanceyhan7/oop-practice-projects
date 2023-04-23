package main.java.com.ceng431.G23_CENG431_HW1.Builder;

import main.java.com.ceng431.G23_CENG431_HW1.Entity.*;
import main.java.com.ceng431.G23_CENG431_HW1.MultilingualismApplication.QUESTION_TYPE;
import main.java.com.ceng431.G23_CENG431_HW1.Service.IQuestionService;
import main.java.com.ceng431.G23_CENG431_HW1.Service.IRandomService;

import java.util.ArrayList;
import java.util.List;

public class QuestionBuilder implements IQuestionService {
    IRandomService random;
    private int MAX_AUDIO_SECONDS = 100;
    private int MAX_STRING_LENGTH = 10;
    private int MAX_WORD_MATCHING_COUNT = 8;
    private int MIN_WORD_MATCHING_COUNT = 4;
    public QuestionBuilder() {
        this.random = new RandomBuilder();
    }

    public <T extends Question> T createQuestion(int questionNumber) {
        QUESTION_TYPE questionType = QUESTION_TYPE.chooseRandomQuestionType();
        Question question = null;
        switch(questionType) {
            case Reading:
                question = (T) createReadingQuestion(questionNumber);
                break;
            case Listening:
                question = (T) createListeningQuestion(questionNumber);
                break;
            case Speaking:
                question = (T) createSpeakingQuestion(questionNumber);
                break;
            case WordMatching:
                question = (T) createWordMatchingQuestion(questionNumber);
                break;
            default:
                System.out.println("Question Type does not exist!");
                break;
        }
        return (T) question;
    }

    private ReadingQuestion createReadingQuestion(int questionNumber){
        Question question = new ReadingQuestion(
            this.random.createRandomString(MAX_STRING_LENGTH),
            this.random.createRandomString(MAX_STRING_LENGTH)
        );
        return (ReadingQuestion) question;
    }

    private ListeningQuestion createListeningQuestion(int questionNumber){
        Question question = new ListeningQuestion(
                this.random.createRandomString(MAX_STRING_LENGTH),
                this.random.createRandomAudio(MAX_AUDIO_SECONDS)
        );
        return (ListeningQuestion) question;
    }

    private SpeakingQuestion createSpeakingQuestion(int questionNumber){
        List<Audio> audios = new ArrayList<>();
        audios.add(random.createRandomAudio(MAX_AUDIO_SECONDS));
        audios.add(random.createRandomAudio(MAX_AUDIO_SECONDS));
        Question question = new SpeakingQuestion(audios);
        return (SpeakingQuestion) question;
    }

    private WordMatchingQuestion createWordMatchingQuestion(int questionNumber){
        int tempWordMatchingCount = random.createRandomInt(MAX_WORD_MATCHING_COUNT - MIN_WORD_MATCHING_COUNT) + MIN_WORD_MATCHING_COUNT;
        Question question = new WordMatchingQuestion(random.createRandomStringMap(tempWordMatchingCount));
        return (WordMatchingQuestion) question;
    }
}
