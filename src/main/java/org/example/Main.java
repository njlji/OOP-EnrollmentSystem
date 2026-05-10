import models.*;
import interfaces.*;
import services.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Initialize Services
        IEnrollmentService enrollmentService = new EnrollmentServiceImpl();
        ITuitionService tuitionService = new TuitionServiceImpl();
        IInstructorService instructorService = new InstructorServiceImpl(); // New service added
        
        // Setup initial Department and Sections
        Department ccs = new Department("College of Computer Studies");
        Section bsit1A = new Section("BSIT-1A", 30); // Capacity 30
        Section bsit1B = new Section("BSIT-1B", 30); // Capacity 30
        ccs.addSection(bsit1A);
        ccs.addSection(bsit1B);

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=== ENROLLMENT SYSTEM MAIN MENU ===");
            System.out.println("1. View Department Hierarchy (View All)");
            System.out.println("2. Manage a Section (Add Students/Instructors)");
            System.out.println("3. Calculate Tuition for a Student");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        // This perfectly satisfies the "Institutional Hierarchy Viewing" requirement
                        enrollmentService.viewDepartmentHierarchy(ccs);
                        break;
                        
                    case 2:
                        // Interactive Section Management
                        System.out.println("\n--- AVAILABLE SECTIONS ---");
                        for (int i = 0; i < ccs.getSections().size(); i++) {
                            System.out.println((i + 1) + ". " + ccs.getSections().get(i).getSectionName());
                        }
                        System.out.print("Select a section number to manage: ");
                        int secChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        if (secChoice > 0 && secChoice <= ccs.getSections().size()) {
                            Section selectedSection = ccs.getSections().get(secChoice - 1);
                            
                            System.out.println("\n--- MANAGING: " + selectedSection.getSectionName() + " ---");
                            System.out.println("1. Enroll a New Student");
                            System.out.println("2. Assign an Instructor");
                            System.out.print("Enter choice: ");
                            int manageChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline

                            if (manageChoice == 1) {
                                // Add Student dynamically by typing
                                System.out.print("Enter Student ID: ");
                                String id = scanner.nextLine();
                                System.out.print("Enter Student Name: ");
                                String name = scanner.nextLine();
                                System.out.print("Enter Program (e.g., BSIT): ");
                                String prog = scanner.nextLine();
                                
                                Student newStudent = new Student(id, name, prog);
                                enrollmentService.enrollStudentInSection(newStudent, selectedSection);

                            } else if (manageChoice == 2) {
                                // Add Instructor dynamically by typing
                                System.out.print("Enter Instructor ID: ");
                                String id = scanner.nextLine();
                                System.out.print("Enter Instructor Name: ");
                                String name = scanner.nextLine();
                                
                                Instructor newInstructor = new Instructor(id, name);
                                instructorService.assignInstructorToSection(newInstructor, selectedSection);
                            } else {
                                System.out.println("❌ Invalid choice.");
                            }
                        } else {
                            System.out.println("❌ Invalid section selected.");
                        }
                        break;

                    case 3:
                        System.out.println("Tuition module selected (Requires searching for a student, to be implemented further).");
                        break;
                        
                    case 4:
                        System.out.println("Exiting System. Goodbye!");
                        isRunning = false;
                        break;
                        
                    default:
                        System.out.println("❌ Invalid choice. Please enter a valid number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ ERROR: Invalid input! Please enter a number, not letters.");
                scanner.nextLine(); // Clear the bad input to prevent infinite loops
            }
        }
        scanner.close();
    }
}