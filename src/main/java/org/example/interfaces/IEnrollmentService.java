package interfaces;
import models.Department;
import models.Section;
import models.Student;

public interface IEnrollmentService {
    void enrollStudentInSection(Student student, Section section);
    void viewDepartmentHierarchy(Department department);
}