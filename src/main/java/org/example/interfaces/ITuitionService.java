package interfaces;
import models.Student;

public interface ITuitionService {
    void calculateFee(Student student, int units);
    void makePayment(Student student, double amount);
    double getRemainingBalance(Student student);
}