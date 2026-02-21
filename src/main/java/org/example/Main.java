package org.example;

import org.example.models.Course;
import org.example.models.Student;
import org.example.service.CourseRegistration;
import org.example.service.StudentRegistration;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner input = new Scanner(System.in);

    static void main() {
        StudentRegistration studentRegistration = new StudentRegistration();
        CourseRegistration courseRegistration = new CourseRegistration();
        Student JohnDoe = new Student("000123", "John Doe", "Information Technology");
        Student JaneDoe = new Student("000124", "Jane Doe", "Information Technology");
        Course Inteprog = new Course("0001", "Integrative Programming", "Information Technology");

        System.out.println(JohnDoe);
        System.out.println("-------------------------");
        System.out.println(JaneDoe);
        System.out.println("-------------------------");
        System.out.println(Inteprog);

        System.out.println("=========================");
        System.out.println("STUDENT REGISTRATION");

        //Save/Add Student
        studentRegistration.saveStudent(JohnDoe);
        studentRegistration.saveStudent(JaneDoe);

        System.out.println("----------------------");
        //Displays all the students
        studentRegistration.displayAllStudent();

        System.out.println("----------------------");
        //Update the Student Info
        studentRegistration.updateStudent("000123", "Carl Tan", "Accounting");
        studentRegistration.displayAllStudent(); // Displays Students

        System.out.println("----------------------");
        //Removes a Student
        studentRegistration.removeStudent("000123");
        studentRegistration.displayAllStudent(); // Displays Students

        System.out.println("==========================");
        System.out.println("COURSE REGISTRATION");

        //Save Course
        courseRegistration.saveCourse(Inteprog);

        System.out.println("----------------------");
        //Display All
        courseRegistration.displayAllCourse();

        System.out.println("----------------------");
        //updateCourse
        courseRegistration.updateCourse("0001", "Art Appreciation", "Artapre");
        courseRegistration.displayAllCourse(); // displays courses

        System.out.println("----------------------");
        //Remove Course
        courseRegistration.removeCourse("0001");
        courseRegistration.displayAllCourse(); // display courses
        System.out.println("*remove course*");
        System.out.println("----------------------");

        System.out.println("==========================");
        // Interactive Student Registration.
        boolean StudentRunning = false;
        boolean CourseRunning = false;
        boolean raning = true;

        while (raning) {
            System.out.println("--------------------");
            System.out.println("1. Enter Student System");
            System.out.println("2. Enter Course System");
            System.out.println("3. Exit");
            System.out.println("--------------------");
            System.out.print("Select: ");
            int selection4 = input.nextInt();
            System.out.println("--------------------");

            switch (selection4) {
                case 1:
                    StudentRunning = true;
                    break;
                case 2:
                    CourseRunning = true;
                    break;
                case 3:
                    raning = false;
                    break;
                default:
                    System.out.println("Try again");
            }

            input.nextLine();

            while (StudentRunning) {
                System.out.println("--------------------");
                System.out.println("1. Save Student");
                System.out.println("2. View All Student");
                System.out.println("3. Edit Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.println("--------------------");
                System.out.print("Select: ");
                int selection = input.nextInt();
                System.out.println("--------------------");
                input.nextLine();

                switch (selection) {
                    case 1:
                        studentRegistration.saveStudent();
                        break;
                    case 2:
                        studentRegistration.displayAllStudent();
                        break;
                    case 3:
                        studentRegistration.updateStudent();
                        break;
                    case 4:
                        studentRegistration.removeStudent();
                        break;
                    case 5:
                        StudentRunning = false;
                        break;
                    default:
                        System.out.println("Invalid Input, Try Again");
                }

            }

            while (CourseRunning) {
                System.out.println("--------------------");
                System.out.println("1. Save Course");
                System.out.println("2. View All Courses");
                System.out.println("3. Edit Course");
                System.out.println("4. Delete Course");
                System.out.println("5. Exit");
                System.out.println("--------------------");
                System.out.print("Select: ");
                int selection = input.nextInt();
                System.out.println("--------------------");
                input.nextLine();

                switch (selection) {
                    case 1:
                        courseRegistration.saveCourse();
                        break;
                    case 2:
                        courseRegistration.displayAllCourse();
                        break;
                    case 3:
                        courseRegistration.updateCourse();
                        break;
                    case 4:
                        courseRegistration.removeCourse();
                        break;
                    case 5:
                        CourseRunning = false;
                        break;
                    default:
                        System.out.println("Invalid Input, Try Again");
                }

            }
        }

    }
}
