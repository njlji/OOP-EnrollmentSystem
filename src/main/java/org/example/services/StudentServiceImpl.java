package services;
import interfaces.IStudentService;
import models.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private List<Student> students = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public Student getStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student; // Student found!
            }
        }
        return null; // Not found
    }

    // You can implement the other methods (update, remove, getAll) later
    @Override
    public void updateStudent(String id, String newName, String newProgram) {}
    @Override
    public void removeStudent(String id) {}
    @Override
    public List<Student> getAllStudents() { return students; }
}