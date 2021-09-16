package school;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private int id_students;
    private String name_students;
    private String gender_students;
    private int age_students;
    private int id_professors;

}
