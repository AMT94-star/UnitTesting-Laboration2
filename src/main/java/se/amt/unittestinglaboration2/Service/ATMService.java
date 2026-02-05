package se.amt.unittestinglaboration2.Service;

import org.springframework.stereotype.Service;
import se.amt.unittestinglaboration2.Component.AccountComponent;
import se.amt.unittestinglaboration2.Exception.InsufficentFundsException;
import se.amt.unittestinglaboration2.Exception.InvalidAmountException;
import se.amt.unittestinglaboration2.Exception.MaxWithdrawalExceededException;

@Service
public class ATMService {
    private final AccountComponent account;

    public ATMService(AccountComponent account) {
        this.account = account;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("The amount must be greater than 0.");
        }
        account.deposit(amount);
        System.out.println("Deposited " + amount);
    }

    public void withdraw(int amount) {
        if (amount < 0) {
            throw new InvalidAmountException("The amount must be greater than 0.");
        }
        if (amount >= 10000) {
            throw new MaxWithdrawalExceededException("The amount must be less than 10000.");
        }
        if (account.getCurrentBalance() < amount) {
            throw new InsufficentFundsException("You don't have enough funds.");
        }
        account.withdraw(amount);
        System.out.println("Withdrawn " + amount);
    }

    public int getBalance() {
        return account.getCurrentBalance();
    }

}
