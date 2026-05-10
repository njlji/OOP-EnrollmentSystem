package services;
import interfaces.IInstructorService;
import models.Instructor;
import models.Section;
import java.util.ArrayList;
import java.util.List;

public class InstructorServiceImpl implements IInstructorService {
    private List<Instructor> instructors = new ArrayList<>();

    @Override
    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }

    @Override
    public void assignInstructorToSection(Instructor instructor, Section section) {
        section.setInstructor(instructor);
        System.out.println("✅ SUCCESS: Instructor " + instructor.getName() + " assigned to section " + section.getSectionName());
    }

    @Override
    public List<Instructor> getInstructorDetails() {
        return instructors;
    }
}