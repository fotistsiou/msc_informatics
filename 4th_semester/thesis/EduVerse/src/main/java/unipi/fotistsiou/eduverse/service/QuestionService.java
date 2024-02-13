package unipi.fotistsiou.eduverse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unipi.fotistsiou.eduverse.entity.Question;
import unipi.fotistsiou.eduverse.entity.Quiz;
import unipi.fotistsiou.eduverse.repository.QuestionRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final Quiz quiz;

    @Autowired
    public QuestionService(
        QuestionRepository questionRepository,
        Quiz quiz
    ){
        this.questionRepository = questionRepository;
        this.quiz = quiz;
    }

    public Optional<Question> findQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    public void deleteQuestion(Question question) {
        questionRepository.delete(question);
    }

    public void saveQuestion(Question question) {
        if (question.getId() == null) {
            question.setChoice(0);
        }
        questionRepository.save(question);
    }

    public List<Question> findAllChapterQuestions(Long chapterId) {
        List<Question> chapterQuestions = new ArrayList<>();
        List<Question> questions = questionRepository.findAll();
        for (Question question:questions) {
            if (question.getChapter().getId().equals(chapterId)) {
                chapterQuestions.add(question);
            }
        }
        return chapterQuestions;
    }

    public Quiz findQuestionsByChapter(Long chapterId) {
        List<Question> allQuestions = questionRepository.findAll();
        List<Question> quizList = new ArrayList<>();
        for (Question question:allQuestions) {
            if (question.getChapter().getId().equals(chapterId)) {
                quizList.add(question);
            }
        }
        quiz.setQuestions(quizList);
        return quiz;
    }
}