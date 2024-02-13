package unipi.fotistsiou.eduverse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="correct", nullable=false)
    private int correct;

    @Column(name="wrong", nullable=false)
    private int wrong;

    @Column(name="feedback", nullable=false)
    private String feedback;

    @ManyToOne
    @JoinColumn(name = "chapter", referencedColumnName = "id", nullable = false)
    private Chapter chapter;

    @ManyToOne
    @JoinColumn(name = "student", referencedColumnName = "id", nullable = false)
    private User student;
}