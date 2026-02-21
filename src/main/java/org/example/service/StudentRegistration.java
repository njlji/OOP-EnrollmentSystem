package org.example.service;

import org.example.models.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentRegistration {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public void saveStudent(Student student){
        students.add(student);
    }

    public void saveStudent(){
        System.out.print("Enter Student Name: ");
        String studentName = input.nextLine();
        System.out.print("Enter StudentID: ");
        String studentID = input.nextLine();
        System.out.print("Enter Program: ");
        String program = input.nextLine();

        students.add(new Student(studentID, studentName, program));
    }

    public void displayAllStudent(){
        for (int i = 0; i < students.size(); i++) {
            System.out.print((i + 1) + ". ");
            System.out.println(students.get(i));
        }
    }

    public void updateStudent(String studentID, String studentName, String program){
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getStudentID().equals(studentID)){
                students.get(i).setStudentName(studentName);
                students.get(i).setProgram(program);
            }
        }
    }

    public void updateStudent(){
        for (int i = 0; i < students.size(); i++) {
            System.out.print((i + 1) + ". ");
            System.out.println(students.get(i));
        }
        System.out.print("Select to be edited: ");
        int selection = input.nextInt();
        selection--;

        input.nextLine();

        System.out.print("Enter Student Name: ");
        String studentName = input.nextLine();
        System.out.print("Enter StudentID: ");
        String studentID = input.nextLine();
        System.out.print("Enter Program: ");
        String program = input.nextLine();

        students.get(selection).setStudentName(studentName);
        students.get(selection).setStudentID(studentID);
        students.get(selection).setProgram(program);
    }


    public void removeStudent(String studentID){
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getStudentID().equals(studentID)){
                students.remove(i);
            }
        }
    }

    public void removeStudent(){
        for (int i = 0; i < students.size(); i++) {
            System.out.print((i + 1) + ". ");
            System.out.println(students.get(i));
        }
        System.out.print("Select to be deleted: ");
        int selection2 = input.nextInt();
        students.remove(selection2 - 1);
    }

}
