package classes;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    public InstructorDetail() {}

    public InstructorDetail(String description) {
        this.description = description;
    }

}
