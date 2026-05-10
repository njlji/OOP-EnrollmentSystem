package interfaces;
import models.Student;
import java.util.List;

public interface IStudentService {
    void addStudent(Student student);
    void updateStudent(String id, String newName, String newProgram);
    void removeStudent(String id);
    List<Student> getAllStudents();
}