package school;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Statement stmt = ConfigurationUtil.getConnection().createStatement();
            String sql = "select * from students";
            ResultSet rs = stmt.executeQuery(sql);
            List<Student> studentList = new ArrayList<>();

            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id_students"),
                        rs.getString("name_students"),
                        rs.getString("gender_students"),
                        rs.getInt("age_students"),
                        rs.getInt("id_professors"));
                studentList.add(student);
            }
            stmt.close();
            rs.close();
//            for (Student student : studentList) {
//                System.out.println(student);
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        StudentRepository studentRepository = new StudentRepository();
//        System.out.println("----------------------------------- I N S E R T -----------------------------------------");
//        Student student1 = new Student(13, "Ionel", "male", 28, 4);
//        Student student2 = new Student(14, "Alexandra", "female", 33, 5);
//        studentRepository.insertStudent(student1);
//        studentRepository.insertStudent(student2);

        System.out.println("----------------------------------- R E A D ---------------------------------------------");
        studentRepository.selectStudent("female", "a");

//        System.out.println("----------------------------------- U P D A T E -----------------------------------------");
//        studentRepository.updateStudent(1, "Ana Maria");
//        studentRepository.updateStudent(2, "Irma");


//        System.out.println("----------------------------------- D E L E T E -----------------------------------------");
//        studentRepository.deleteStudent(13);
//        studentRepository.deleteStudent(14);




    }

}
