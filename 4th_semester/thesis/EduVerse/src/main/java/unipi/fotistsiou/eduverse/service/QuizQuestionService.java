package unipi.fotistsiou.eduverse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unipi.fotistsiou.eduverse.entity.*;
import unipi.fotistsiou.eduverse.repository.QuizQuestionRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizQuestionService {
    private final QuizQuestionRepository quizQuestionRepository;
    private final QuestionService questionService;

    @Autowired
    public QuizQuestionService(
        QuizQuestionRepository quizQuestionRepository,
        QuestionService questionService
    ){
        this.quizQuestionRepository = quizQuestionRepository;
        this.questionService = questionService;
    }

    public Optional<QuizQuestion> findQuizQuestionById(Long id) {
        return quizQuestionRepository.findById(id);
    }

    public void saveQuizQuestions(Quiz quiz, Result result, User student) {
        for (Question question:quiz.getQuestions()) {
            QuizQuestion quizQuestion = new QuizQuestion();
            quizQuestion.setTitle(question.getTitle());
            quizQuestion.setAnswer(getOptionByAnswer(question));
            quizQuestion.setChoice(getOptionByChoice(question));
            quizQuestion.setChapter(question.getChapter());
            quizQuestion.setResult(result);
            quizQuestion.setStudent(student);
            quizQuestionRepository.save(quizQuestion);
        }
    }

    public List<QuizQuestion> findQuizQuestionsByResultId(Long resultId) {
        List<QuizQuestion> resultQuizQuestions = new ArrayList<>();
        List<QuizQuestion> quizQuestions = quizQuestionRepository.findAll();
        for (QuizQuestion quizQuestion:quizQuestions) {
            if (quizQuestion.getResult().getId().equals(resultId)) {
                resultQuizQuestions.add(quizQuestion);
            }
        }
        return resultQuizQuestions;
    }

    /* --------------- Helper Functions --------------- */

    private String getOptionByAnswer(Question question) {
        String optionAnswer = "something went wrong";
        Optional<Question> optionalQuestion = questionService.findQuestionById(question.getId());
        if (optionalQuestion.isPresent()) {
            Question originQuestion = optionalQuestion.get();
            optionAnswer = switch (question.getAnswer()) {
                case 1 -> originQuestion.getOption_a();
                case 2 -> originQuestion.getOption_b();
                case 3 -> originQuestion.getOption_c();
                default -> "something went wrong";
            };
        }
        return optionAnswer;
    }

    private String getOptionByChoice(Question question) {
        String optionChoice = "something went wrong";
        Optional<Question> optionalQuestion = questionService.findQuestionById(question.getId());
        if (optionalQuestion.isPresent()) {
            Question originQuestion = optionalQuestion.get();
            optionChoice = switch (question.getChoice()) {
                case 1 -> originQuestion.getOption_a();
                case 2 -> originQuestion.getOption_b();
                case 3 -> originQuestion.getOption_c();
                default -> "something went wrong";
            };
        }
        return optionChoice;
    }
}