package org.example.service;

import org.example.models.Course;

import java.util.ArrayList;

public class CourseRegistration {
    private ArrayList<Course> courses = new ArrayList<>();

    public void saveCourse(Course course){
        courses.add(course);
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

    public void removeCourse(String courseID){
        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getCourseID().equals(courseID)){
                courses.remove(i);
            }
        }
    }
}
