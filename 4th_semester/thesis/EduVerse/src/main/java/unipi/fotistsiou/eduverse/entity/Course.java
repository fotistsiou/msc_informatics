package unipi.fotistsiou.eduverse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Ο κωδικός μαθήματος δεν μπορεί να είναι κενός.")
    @Column(name="code", nullable=false, unique=true)
    private String code;

    @NotEmpty(message = "O τίτλος δεν μπορεί να είναι κενός.")
    @Column(name="title", nullable=false)
    private String title;

    @NotEmpty(message = "Η περιγραφή δεν μπορεί να είναι κενή.")
    @Column(name="description", nullable=false, columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "professor", referencedColumnName = "id", nullable = false)
    private User professor;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "course_students",
        joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "student", referencedColumnName = "id")
    )
    private Set<User> students = new HashSet<>();
}