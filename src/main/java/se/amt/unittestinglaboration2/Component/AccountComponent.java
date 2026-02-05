package se.amt.unittestinglaboration2.Component;

import org.springframework.stereotype.Component;

@Component
public class AccountComponent {
    private int currentBalance = 0;

    public void deposit(int amount) {
        this.currentBalance += amount;
    }

    public void withdraw(int amount) {
        this.currentBalance -= amount;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }
}
