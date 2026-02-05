package se.amt.unittestinglaboration2.Component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountComponentTest {
    private AccountComponent account;

    @BeforeEach
    public void setUp() {
        account = new AccountComponent();
    }

    //test av start saldo
    @Test
    public void testAccountBalance() {
        assertEquals(0, account.getCurrentBalance());
    }

    //test av deposit
    @Test
    public void testAccountDeposit() {
        account.deposit(100);
        assertEquals(100, account.getCurrentBalance());
        System.out.println("Current balance is " + account.getCurrentBalance());
    }

    //test av withdraw
    @Test
    public void testAccountWithdraw() {
        account.withdraw(100);
        assertEquals(-100, account.getCurrentBalance());
        System.out.println("Current balance is " + account.getCurrentBalance());
    }

    //test av både deposit och withdraw
    @Test
    public void testAccountUsage() {
        System.out.println("Current balance is " + account.getCurrentBalance());
        account.deposit(1000);
        assertEquals(1000, account.getCurrentBalance());
        System.out.println("Current balance is " + account.getCurrentBalance());

        account.withdraw(500);
        assertEquals(500, account.getCurrentBalance());
        System.out.println("Current balance is " + account.getCurrentBalance());

        account.deposit(1);
        assertEquals(501, account.getCurrentBalance());
        System.out.println("Current balance is " + account.getCurrentBalance());
    }
}
