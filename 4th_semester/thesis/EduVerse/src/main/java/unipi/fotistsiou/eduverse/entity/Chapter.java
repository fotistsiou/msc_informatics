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
@Table(name="chapter")
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O τίτλος δεν μπορεί να είναι κενός.")
    @Column(name="title", nullable=false)
    private String title;

    @NotEmpty(message = "Το περιεχόμενο δεν μπορεί να είναι κενή.")
    @Column(name="content", nullable=false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course", referencedColumnName = "id", nullable = false)
    private Course course;
}