package interfaces;
import models.Course;
import java.util.List;

public interface ICourseService {
    void addCourse(Course course);
    void updateCourse(String id, String newName);
    void removeCourse(String id);
    List<Course> getAllCourses();
}