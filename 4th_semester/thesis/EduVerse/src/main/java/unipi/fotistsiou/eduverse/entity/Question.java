package unipi.fotistsiou.eduverse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O τίτλος δεν μπορεί να είναι κενός.")
    @Column(name="title", nullable=false, columnDefinition = "TEXT")
    private String title;

    @NotEmpty(message = "O επιλογή Α δεν μπορεί να είναι κενή.")
    @Column(name="option_a", nullable=false)
    private String option_a;

    @NotEmpty(message = "O επιλογή Β δεν μπορεί να είναι κενή.")
    @Column(name="option_b", nullable=false)
    private String option_b;

    @NotEmpty(message = "O επιλογή Γ δεν μπορεί να είναι κενή.")
    @Column(name="option_c", nullable=false)
    private String option_c;

    @Column(name="answer", nullable=false)
    private int answer;

    @Column(name="choice", nullable=false)
    private int choice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chapter", referencedColumnName = "id", nullable = false)
    private Chapter chapter;
}