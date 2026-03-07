package org.example.models;

public class Student extends Person{
    private String program;

    public Student(){

    }

    public Student(String studentID, String studentName, String program){
        super(studentName,studentID);
        this.program = program;
    }

    public String getStudentID(){
        return super.getID();
    }

//    public void setStudentID(String studentID){
//        super.setID(studentID);
//    }
//
//    public String getStudentName(){
//        return super.getName();
//    }
//
//    public void setStudentName(String studentName){
//        super.setName(studentName);
//    }

    public String getProgram(){
        return program;
    }

    public void setProgram(String program){
        this.program = program;
    }

    @Override
    public String toString(){
        return "StudentID: " + super.getID() + "\nStudent Name: " + super.getName() + "\nProgram: " + program;
    }
}
