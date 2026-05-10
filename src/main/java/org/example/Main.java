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
        IInstructorService instructorService = new InstructorServiceImpl();
        IStudentService studentService = new StudentServiceImpl(); 
        
        // Setup initial dummy data
        Department ccs = new Department("College of Computer Studies");
        Section bsit1A = new Section("BSIT-1A", 30); 
        ccs.addSection(bsit1A);

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=== ENROLLMENT SYSTEM MAIN MENU ===");
            System.out.println("1. View Department Hierarchy");
            System.out.println("2. Manage Sections (Add/Remove Sections, Students, Instructors)");
            System.out.println("3. Calculate Tuition for a Student");
            System.out.println("4. Pay Tuition / Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        enrollmentService.viewDepartmentHierarchy(ccs);
                        break;
                        
                    case 2:
                        boolean managingSections = true;
                        while (managingSections) {
                            System.out.println("\n--- SECTION MANAGEMENT ---");
                            System.out.println("1. Add a New Section");
                            System.out.println("2. Remove a Section");
                            System.out.println("3. Manage an Existing Section (Add Students/Instructors)");
                            System.out.println("4. Go Back to Main Menu");
                            System.out.print("Enter choice: ");
                            
                            int secMenuChoice = scanner.nextInt();
                            scanner.nextLine();

                            if (secMenuChoice == 1) {
                                // ADD A SECTION
                                System.out.print("Enter new Section Name (e.g., BSIT-1C): ");
                                String secName = scanner.nextLine();
                                System.out.print("Enter Maximum Capacity: ");
                                int capacity = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                
                                ccs.addSection(new Section(secName, capacity));
                                System.out.println("✅ SUCCESS: Section " + secName + " has been created.");

                            } else if (secMenuChoice == 2) {
                                // REMOVE A SECTION
                                System.out.print("Enter the EXACT name of the Section to remove: ");
                                String secName = scanner.nextLine();
                                
                                if (ccs.removeSection(secName)) {
                                    System.out.println("✅ SUCCESS: Section " + secName + " was removed.");
                                } else {
                                    System.out.println("❌ ERROR: Section '" + secName + "' not found.");
                                }

                            } else if (secMenuChoice == 3) {
                                // MANAGE AN EXISTING SECTION (Add/Remove)
                                if (ccs.getSections().isEmpty()) {
                                    System.out.println("❌ ERROR: No sections available. Create one first.");
                                    continue;
                                }

                                System.out.println("\n--- AVAILABLE SECTIONS ---");
                                for (int i = 0; i < ccs.getSections().size(); i++) {
                                    System.out.println((i + 1) + ". " + ccs.getSections().get(i).getSectionName());
                                }
                                System.out.print("Select a section number to manage: ");
                                int secChoice = scanner.nextInt();
                                scanner.nextLine();

                                if (secChoice > 0 && secChoice <= ccs.getSections().size()) {
                                    Section selectedSection = ccs.getSections().get(secChoice - 1);

                                    System.out.println("\n--- MANAGING: " + selectedSection.getSectionName() + " ---");
                                    System.out.println("1. Enroll a New Student");
                                    System.out.println("2. Assign an Instructor");
                                    System.out.println("3. Remove a Student from this Section"); // NEW OPTION
                                    System.out.print("Enter choice: ");
                                    int manageChoice = scanner.nextInt();
                                    scanner.nextLine();

                                    if (manageChoice == 1) {
                                        System.out.print("Enter Student ID: ");
                                        String id = scanner.nextLine();
                                        System.out.print("Enter Student Name: ");
                                        String name = scanner.nextLine();
                                        System.out.print("Enter Program: ");
                                        String prog = scanner.nextLine();

                                        Student newStudent = new Student(id, name, prog);
                                        studentService.addStudent(newStudent);
                                        enrollmentService.enrollStudentInSection(newStudent, selectedSection);

                                    } else if (manageChoice == 2) {
                                        System.out.print("Enter Instructor ID: ");
                                        String id = scanner.nextLine();
                                        System.out.print("Enter Instructor Name: ");
                                        String name = scanner.nextLine();

                                        Instructor newInstructor = new Instructor(id, name);
                                        instructorService.assignInstructorToSection(newInstructor, selectedSection);

                                    } else if (manageChoice == 3) {
                                        // NEW LOGIC: Remove Student
                                        System.out.print("Enter Student ID to remove: ");
                                        String removeId = scanner.nextLine();
                                        Student studentToRemove = studentService.getStudentById(removeId);

                                        if (studentToRemove != null) {
                                            enrollmentService.removeStudentFromSection(studentToRemove, selectedSection);
                                        } else {
                                            System.out.println("❌ ERROR: Student not found in the global database.");
                                        }

                                    } else {
                                        System.out.println("❌ Invalid choice.");
                                    }
                                } else {
                                    System.out.println("❌ Invalid section selected.");
                                }
                            }else if (secMenuChoice == 4) {
                                managingSections = false; // Exits the sub-menu loop
                            } else {
                                System.out.println("❌ Invalid choice. Please enter 1-4.");
                            }
                        }
                        break;

                    case 3:
                        // TUITION MODULE: CALCULATE
                        System.out.print("Enter Student ID to search: ");
                        String searchId = scanner.nextLine();
                        Student foundStudent = studentService.getStudentById(searchId);

                        if (foundStudent != null) {
                            System.out.print("Enter number of units for " + foundStudent.getName() + ": ");
                            int units = scanner.nextInt();
                            tuitionService.calculateFee(foundStudent, units);
                        } else {
                            System.out.println("❌ ERROR: Student not found. Please ensure they are enrolled first.");
                        }
                        break;
                        
                    case 4:
                        // TUITION MODULE: PAYMENTS
                        System.out.print("Enter Student ID to process payment: ");
                        String payId = scanner.nextLine();
                        Student payStudent = studentService.getStudentById(payId);

                        if (payStudent != null) {
                            double balance = tuitionService.getRemainingBalance(payStudent);
                            System.out.println("Current Balance for " + payStudent.getName() + ": P" + balance);
                            
                            if (balance > 0) {
                                System.out.print("Enter payment amount: ");
                                double payment = scanner.nextDouble();
                                tuitionService.makePayment(payStudent, payment);
                            } else {
                                System.out.println("✅ This student is fully paid.");
                            }
                        } else {
                            System.out.println("❌ ERROR: Student not found.");
                        }
                        break;

                    case 5:
                        System.out.println("Exiting System. Goodbye!");
                        isRunning = false;
                        break;
                        
                    default:
                        System.out.println("❌ Invalid choice. Please enter a valid number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ ERROR: Invalid input! Please enter a number, not letters.");
                scanner.nextLine(); 
            }
        }
        scanner.close();
    }
}