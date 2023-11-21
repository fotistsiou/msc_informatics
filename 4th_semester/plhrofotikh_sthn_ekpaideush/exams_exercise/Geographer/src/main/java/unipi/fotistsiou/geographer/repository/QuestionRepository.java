package unipi.fotistsiou.geographer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unipi.fotistsiou.geographer.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {}