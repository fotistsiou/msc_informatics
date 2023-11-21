package unipi.fotistsiou.geographer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unipi.fotistsiou.geographer.entity.Result;

public interface ResultRepository extends JpaRepository<Result, Long> {}