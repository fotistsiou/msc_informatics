package unipi.fotistsiou.geographer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unipi.fotistsiou.geographer.entity.Question;
import unipi.fotistsiou.geographer.entity.Quiz;
import unipi.fotistsiou.geographer.entity.Result;
import unipi.fotistsiou.geographer.repository.ResultRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResultService {
    private final ResultRepository resultRepository;

    @Autowired
    public ResultService (
        ResultRepository resultRepository
    ){
        this.resultRepository = resultRepository;
    }

    public Optional<Result> getResultById(Long id) {
        return resultRepository.findById(id);
    }

    public List<Result> getUserResults(Long userId) {
        List<Result> userResults = new ArrayList<>();
        List<Result> results = resultRepository.findAll();
        for (Result result:results) {
            if (result.getUser().getId().equals(userId)) {
                userResults.add(result);
            }
        }
        return userResults;
    }

    public int getResult(Quiz quiz) {
        int correct = 0;
        for(Question answer:quiz.getQuestions()) {
            if (answer.getAnswer() == answer.getChoice()) {
                correct++;
            }
        }
        return correct;
    }

    public void saveResult(Result result) {
        resultRepository.save(result);
    }
}
