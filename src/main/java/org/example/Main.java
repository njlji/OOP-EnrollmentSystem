package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Student JohnDoe = new Student("000123", "John Doe", "Information Technology");
        Student JaneDoe = new Student("000124", "Jane Doe", "Information Technology");
        Course Inteprog = new Course("0001", "Integrative Programming", "Information Technology");

        System.out.println(JohnDoe);
        System.out.println("-------------------------");
        System.out.println(JaneDoe);
        System.out.println("-------------------------");
        System.out.println(Inteprog);

    }
}
