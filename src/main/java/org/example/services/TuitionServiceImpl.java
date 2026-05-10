package services;
import interfaces.ITuitionService;
import models.Student;

public class TuitionServiceImpl implements ITuitionService {
    private final double PRICE_PER_UNIT = 1000.00;

    @Override
    public void calculateFee(Student student, int units) {
        double fee = units * PRICE_PER_UNIT;
        student.getTuitionAccount().setTotalTuition(fee);
        student.getTuitionAccount().setRemainingBalance(fee);
        System.out.println("Tuition calculated for " + student.getName() + ": P" + fee);
    }

    @Override
    public void makePayment(Student student, double amount) {
        double currentBalance = student.getTuitionAccount().getRemainingBalance();
        if (amount > currentBalance) {
            System.out.println("Payment exceeds remaining balance!");
        } else {
            student.getTuitionAccount().setRemainingBalance(currentBalance - amount);
            System.out.println("Payment of P" + amount + " successful. New Balance: P" + student.getTuitionAccount().getRemainingBalance());
        }
    }

    @Override
    public double getRemainingBalance(Student student) {
        return student.getTuitionAccount().getRemainingBalance();
    }
}