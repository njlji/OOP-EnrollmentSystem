package services;
import interfaces.IEnrollmentService;
import models.Department;
import models.Section;
import models.Student;

public class EnrollmentServiceImpl implements IEnrollmentService {

    @Override
    public void enrollStudentInSection(Student student, Section section) {
        // CRITICAL VALIDATION: Capacity Checking
        if (section.getEnrolledStudents().size() >= section.getMaxCapacity()) {
            System.out.println("❌ ERROR: Cannot enroll " + student.getName() + ". Section " + section.getSectionName() + " is FULL!");
        } else {
            section.getEnrolledStudents().add(student);
            System.out.println("✅ SUCCESS: " + student.getName() + " enrolled in " + section.getSectionName());
        }
    }

    @Override
    public void viewDepartmentHierarchy(Department department) {
        System.out.println("\n=== HIERARCHY FOR: " + department.getDepartmentName() + " ===");
        
        for (Section section : department.getSections()) {
            System.out.println("  ↳ Section: " + section.getSectionName() + " (Capacity: " + section.getEnrolledStudents().size() + "/" + section.getMaxCapacity() + ")");
            
            if (section.getInstructor() != null) {
                System.out.println("      Instructor: " + section.getInstructor().getName());
            } else {
                System.out.println("      Instructor: TBA");
            }

            System.out.println("      Students:");
            if (section.getEnrolledStudents().isEmpty()) {
                System.out.println("        - No students enrolled yet.");
            } else {
                for (Student student : section.getEnrolledStudents()) {
                    System.out.println("        - " + student.getName() + " (" + student.getId() + ")");
                }
            }
        }
        System.out.println("=========================================\n");
    }
}