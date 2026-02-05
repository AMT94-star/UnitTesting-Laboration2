package se.amt.unittestinglaboration2.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.amt.unittestinglaboration2.Component.AccountComponent;
import se.amt.unittestinglaboration2.Exception.InsufficentFundsException;
import se.amt.unittestinglaboration2.Exception.InvalidAmountException;
import se.amt.unittestinglaboration2.Exception.MaxWithdrawalExceededException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ATMServiceTest {

    @Mock
    private AccountComponent accountComponent;

    @InjectMocks
    private ATMService atmService;

    //testar felaktiga flöden
    @Test
    public void depositInvalidExceptionTest() {
        assertThrows(InvalidAmountException.class,
                () -> atmService.deposit(0));
    }

    @Test
    public void withdrawMaxExceedExceptionTest() {
        assertThrows(MaxWithdrawalExceededException.class,
                () -> atmService.withdraw(10000));
    }

    @Test
    public void withdrawInsuffienctFundsExceptionTest() {
        //mockar så att vi har ett "värde" i saldot
        when(accountComponent.getCurrentBalance()).thenReturn(50);

        assertThrows(InsufficentFundsException.class,
                () -> atmService.withdraw(100));
    }

    //testar normala flöden
    @Test
    public void depositTest() {
        atmService.deposit(100);
        verify(accountComponent).deposit(100);
    }

    @Test
    public void withdrawTest() {
        when(accountComponent.getCurrentBalance()).thenReturn(500);
        atmService.withdraw(50);
        verify(accountComponent).withdraw(50);
    }

    @Test
    public void getBalanceTest() {
        when(accountComponent.getCurrentBalance()).thenReturn(500);
        int balance = atmService.getBalance();
        assertEquals(500, balance);
    }
}
