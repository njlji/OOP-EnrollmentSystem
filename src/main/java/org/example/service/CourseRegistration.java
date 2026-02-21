package org.example.service;

import org.example.models.Course;

import java.util.ArrayList;

public class CourseRegistration {
    private ArrayList<Course> courses = new ArrayList<>();

    public void saveCourse(Course course){
        courses.add(course);
    }


}
