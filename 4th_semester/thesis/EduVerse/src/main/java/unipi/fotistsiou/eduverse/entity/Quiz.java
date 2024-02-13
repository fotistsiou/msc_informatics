package unipi.fotistsiou.eduverse.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Component
public class Quiz {
    private List<Question> questions;
}