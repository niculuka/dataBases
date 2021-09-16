package school;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    public int insertStudent(Student student) {
        String sql = "insert into students values(?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = ConfigurationUtil.getConnection().prepareStatement(sql)){
            stmt.setInt(1, student.getId_students());
            stmt.setString(2, student.getName_students());
            stmt.setString(3, student.getGender_students());
            stmt.setInt(4, student.getAge_students());
            stmt.setInt(5, student.getId_professors());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void selectStudent(String gender, String ch) {
        String sql = "select * from students where gender_students = '" + gender + "' AND name_students LIKE '" + ch + "%';";
        System.out.println(sql);
        try {
            PreparedStatement stmt = ConfigurationUtil.getConnection().prepareStatement(sql);
            stmt.executeQuery(sql);
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
            for (Student student : studentList) {
                System.out.println(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(int id, String name) {
        String sql = "UPDATE students SET name_students = '" + name + "' WHERE id_students = " + id + ";";
        System.out.println(sql);
        try (PreparedStatement stmt = ConfigurationUtil.getConnection().prepareStatement(sql)) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        String sql = "delete from students where id_students = " + id  + ";";
        System.out.println(sql);
        try (PreparedStatement stmt = ConfigurationUtil.getConnection().prepareStatement(sql)) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
