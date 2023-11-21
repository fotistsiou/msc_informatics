package unipi.fotistsiou.geographer.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name="title", nullable=false)
    private String title;

    @NotEmpty
    @Column(name="chapter", nullable=false)
    private String chapter;

    @NotEmpty
    @Column(name="option_a", nullable=false)
    private String optionA;

    @NotEmpty
    @Column(name="option_b", nullable=false)
    private String optionB;

    @NotEmpty
    @Column(name="option_c", nullable=false)
    private String optionC;

    @NotEmpty
    @Column(name="answer", nullable=false)
    private int answer;

    @Column(name="choice", nullable=false)
    private int choice;
}