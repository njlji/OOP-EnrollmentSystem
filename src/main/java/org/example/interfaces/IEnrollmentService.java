package interfaces;
import models.Department;
import models.Section;
import models.Student;

public interface IEnrollmentService {
    void enrollStudentInSection(Student student, Section section);
    void viewDepartmentHierarchy(Department department);
    
    // NEW: Method to remove a student
    void removeStudentFromSection(Student student, Section section);
}