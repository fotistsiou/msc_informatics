package unipi.fotistsiou.eduverse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "quiz_question")
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title", nullable=false, columnDefinition = "TEXT")
    private String title;

    @Column(name="answer", nullable=false)
    private String answer;

    @Column(name="choice", nullable=false)
    private String choice;

    @ManyToOne
    @JoinColumn(name = "chapter", referencedColumnName = "id", nullable = false)
    private Chapter chapter;

    @ManyToOne
    @JoinColumn(name = "result", referencedColumnName = "id", nullable = false)
    private Result result;

    @ManyToOne
    @JoinColumn(name = "student", referencedColumnName = "id", nullable = false)
    private User student;
}
