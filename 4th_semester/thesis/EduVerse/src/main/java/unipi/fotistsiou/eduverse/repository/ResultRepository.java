package unipi.fotistsiou.eduverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unipi.fotistsiou.eduverse.entity.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {}