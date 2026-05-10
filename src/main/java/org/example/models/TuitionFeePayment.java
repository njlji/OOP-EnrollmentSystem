package models;

public class TuitionFeePayment {
    private double totalTuition;
    private double remainingBalance;

    public TuitionFeePayment() {
        this.totalTuition = 0.0;
        this.remainingBalance = 0.0;
    }

    public double getTotalTuition() { return totalTuition; }
    public void setTotalTuition(double totalTuition) { this.totalTuition = totalTuition; }
    public double getRemainingBalance() { return remainingBalance; }
    public void setRemainingBalance(double remainingBalance) { this.remainingBalance = remainingBalance; }
}