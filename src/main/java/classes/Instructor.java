package classes;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;


    public Instructor(int id, String name, String email, InstructorDetail instructorDetail) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.instructorDetail = instructorDetail;
    }

    public Instructor(String name, String email, InstructorDetail instructorDetail) {
        this.name = name;
        this.email = email;
        this.instructorDetail = instructorDetail;
    }
}
