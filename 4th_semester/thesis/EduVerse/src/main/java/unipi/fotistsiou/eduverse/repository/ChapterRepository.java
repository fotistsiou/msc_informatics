package unipi.fotistsiou.eduverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unipi.fotistsiou.eduverse.entity.Chapter;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Long> {}