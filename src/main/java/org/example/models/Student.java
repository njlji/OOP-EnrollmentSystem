package models;

public class Student extends Person {
    private String program;

    public Student(String id, String name, String program) {
        super(id, name);
        this.program = program;
    }

    public String getProgram() { return program; }
    public void setProgram(String program) { this.program = program; }

    private TuitionFeePayment tuitionAccount = new TuitionFeePayment();

    public TuitionFeePayment getTuitionAccount() { return tuitionAccount; }

    @Override
    public String toString() {
        return "Student ID: " + getId() + " | Name: " + getName() + " | Program: " + program;
    }
}