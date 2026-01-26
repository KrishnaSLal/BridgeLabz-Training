package com.junit.testingbankingtransactions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(1000.0);
    }

    // ✅ Deposit updates balance correctly
    @Test
    void testDeposit() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance());
    }

    // Withdraw updates balance correctly
    @Test
    void testWithdraw() {
        account.withdraw(300.0);
        assertEquals(700.0, account.getBalance());
    }

    // Withdrawal fails if funds are insufficient
    @Test
    void testWithdrawInsufficientFunds() {
        assertThrows(IllegalStateException.class, () -> {
            account.withdraw(2000.0);
        });
    }

    // Invalid deposit amount
    @Test
    void testInvalidDeposit() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-100.0);
        });
    }

    // Invalid withdrawal amount
    @Test
    void testInvalidWithdraw() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(0);
        });
    }
}
