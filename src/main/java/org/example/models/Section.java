package models;
import java.util.ArrayList;
import java.util.List;

public class Section {
    private String sectionName;
    private int maxCapacity;
    private Instructor instructor;
    private List<Student> enrolledStudents;

    public Section(String sectionName, int maxCapacity) {
        this.sectionName = sectionName;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getSectionName() { return sectionName; }
    public int getMaxCapacity() { return maxCapacity; }
    public Instructor getInstructor() { return instructor; }
    public void setInstructor(Instructor instructor) { this.instructor = instructor; }
    public List<Student> getEnrolledStudents() { return enrolledStudents; }
}