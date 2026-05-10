package interfaces;
import models.Instructor;
import models.Section;
import java.util.List;

public interface IInstructorService {
    void addInstructor(Instructor instructor);
    void assignInstructorToSection(Instructor instructor, Section section);
    List<Instructor> getInstructorDetails();
}