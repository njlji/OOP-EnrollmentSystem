package models;

public class Instructor extends Person {
    public Instructor(String id, String name) {
        super(id, name);
    }
    
    @Override
    public String toString() {
        return "Instructor: " + getName();
    }
}