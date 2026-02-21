package org.example.service;

import org.example.models.Course;

import java.util.*;

public class CourseRegistration {
    private ArrayList<Course> courses = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public void saveCourse(Course course){
        courses.add(course);
    }

    public void saveCourse(){
        System.out.print("Enter Course Name: ");
        String courseName = input.nextLine();
        System.out.print("Enter CourseID: ");
        String courseID = input.nextLine();
        System.out.print("Enter Program: ");
        String program = input.nextLine();

        courses.add(new Course(courseID, courseName, program));
    }

    public void displayAllCourse(){
        for (int i = 0; i < courses.size(); i++) {
            System.out.print((i + 1) + ". ");
            System.out.println(courses.get(i));
        }
    }

    public void updateCourse(String courseID, String courseName, String program){
        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getCourseID().equals(courseID)){
                courses.get(i).setCourseName(courseName);
                courses.get(i).setProgram(program);
            }
        }
    }

    public void updateCourse(){
        for (int i = 0; i < courses.size(); i++) {
            System.out.print((i + 1) + ". ");
            System.out.println(courses.get(i));
        }
        System.out.print("Select to be edited: ");
        int selection1 = input.nextInt();
        selection1--;

        input.nextLine();

        System.out.print("Enter Student Name: ");
        String courseName = input.nextLine();
        System.out.print("Enter StudentID: ");
        String courseID = input.nextLine();
        System.out.print("Enter Program: ");
        String program = input.nextLine();

        courses.get(selection1).setCourseName(courseName);
        courses.get(selection1).setCourseID(courseID);
        courses.get(selection1).setProgram(program);
    }

    public void removeCourse(String courseID){
        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getCourseID().equals(courseID)){
                courses.remove(i);
            }
        }
    }

    public void removeCourse(){
        for (int i = 0; i < courses.size(); i++) {
            System.out.print((i + 1) + ". ");
            System.out.println(courses.get(i));
        }
        System.out.print("Select to be deleted: ");
        int selection2 = input.nextInt();
        courses.remove(selection2 - 1);
    }
}
