package unipi.fotistsiou.eduverse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable=false, unique=true)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
    Set<User> users;

    @Override
    public String toString() {
        return name;
    }
}