package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuitionFeePaymentTest {
    private  TuitionFeePayment tuitionfee;
    @BeforeEach
    void setup(){
        tuitionfee = new TuitionFeePayment();
    }

    @Test
    void ShouldCalculateCorrectly(){
        assertEquals(26000.00, tuitionfee.calculateTuitionFee(26, 0));
    }

    @Test
    void ShouldMakePaymentCorrectly(){
        tuitionfee.calculateTuitionFee(26,0);
        tuitionfee.makePayment(5000);
        assertEquals(21000, tuitionfee.getRemainingBalance());
    }

    @Test
    void ShouldReturnCorrectBalance(){
        tuitionfee.calculateTuitionFee(26,0);
        assertEquals(26000, tuitionfee.getRemainingBalance());
    }

    @Test
    void ShouldReturnFullyPaid(){
        tuitionfee.calculateTuitionFee(26,0);
        tuitionfee.makePayment(26000);
        assertTrue(tuitionfee.isFullyPaid());
    }

    @Test
    void ShouldReturnNotFullyPaid(){
        tuitionfee.calculateTuitionFee(26,0);
        tuitionfee.makePayment(20000);
        assertFalse(tuitionfee.isFullyPaid());
    }
}