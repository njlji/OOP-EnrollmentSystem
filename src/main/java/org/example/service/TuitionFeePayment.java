package org.example.service;

public class TuitionFeePayment {
    private double pricePerUnit = 1000.00;
    private double balance;
    private double totalTuition;

    public TuitionFeePayment(){

    }

    public double calculateTuitionFee(int units, double discountRate){
        double holder = pricePerUnit * units;
        if(holder != 0 || discountRate != 0){
            holder = holder * discountRate;
            totalTuition = (pricePerUnit * units) - holder;
        }else{
            totalTuition = pricePerUnit * units;
        }
        return totalTuition;
    }

    public void makePayment(double amount){
        balance += amount;
    }

    public double getRemainingBalance(){
        return (totalTuition - balance);
    }

    public boolean isFullyPaid(){
        totalTuition -= balance;
        if(totalTuition == 0){
            return true;
        }else{
            return false;
        }
    }
}
