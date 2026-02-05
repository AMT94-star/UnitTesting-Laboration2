package se.amt.unittestinglaboration2.Exception;

public class MaxWithdrawalExceededException extends RuntimeException {
    public MaxWithdrawalExceededException(String message) {
        super(message);
    }
}
