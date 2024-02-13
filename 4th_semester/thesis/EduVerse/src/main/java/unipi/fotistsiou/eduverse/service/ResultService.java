package unipi.fotistsiou.eduverse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unipi.fotistsiou.eduverse.entity.Question;
import unipi.fotistsiou.eduverse.entity.Quiz;
import unipi.fotistsiou.eduverse.entity.Result;
import unipi.fotistsiou.eduverse.repository.ResultRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResultService {
    private final ResultRepository resultRepository;

    @Autowired
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public Optional<Result> findResultById(Long id) {
        return resultRepository.findById(id);
    }

    public void saveResult(Result result) {
        resultRepository.save(result);
    }

    public int generateCorrects(Quiz quiz) {
        int corrects = 0;
        for(Question answer:quiz.getQuestions()) {
            if (answer.getAnswer() == answer.getChoice()) {
                corrects++;
            }
        }
        return corrects;
    }

    public int generateWrongs(Quiz quiz) {
        int wrongs = 0;
        for(Question answer:quiz.getQuestions()) {
            if (answer.getAnswer() != answer.getChoice()) {
                wrongs++;
            }
        }
        return wrongs;
    }

    public String generateFeedback(int corrects, int wrongs) {
        String feedback;
        float percent = (float) corrects / (corrects + wrongs);
        if (percent > 0.85) {
            feedback = "Μπορείς να προχωρήσεις στο επόμενο κεφάλαιο.";
        }
        else if (percent > 0.65) {
            feedback = "Θα ήταν καλό να διαβάσεις ξανά το κεφάλαιο και να επαναλάβεις το ερωτηματολόγιο.";
        } else {
            feedback = "Θα πρέπει να διαβάσεις ξανά το κεφάλαιο και να επαναλάβεις το ερωτηματολόγιο.";
        }
        return feedback;
    }

    public List<Result> findStudentResults(Long userId) {
        List<Result> userResults = new ArrayList<>();
        List<Result> results = resultRepository.findAll();
        for (Result result:results) {
            if (result.getStudent().getId().equals(userId)) {
                userResults.add(result);
            }
        }
        return userResults;
    }

    public List<Result> findStudentCourseResults(Long courseId, Long userId) {
        List<Result> userResults = new ArrayList<>();
        List<Result> results = resultRepository.findAll();
        for (Result result:results) {
            if (result.getStudent().getId().equals(userId) && result.getChapter().getCourse().getId().equals(courseId)) {
                userResults.add(result);
            }
        }
        return userResults;
    }
}