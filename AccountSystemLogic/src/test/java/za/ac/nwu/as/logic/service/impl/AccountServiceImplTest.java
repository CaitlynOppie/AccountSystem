package za.ac.nwu.as.logic.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.as.domain.dto.AccountDto;
import za.ac.nwu.as.translator.flow.AccountTranslator;

import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {

    @Mock
    private AccountTranslator accTranslator;

    @InjectMocks
    private AccountServiceImpl accService;

    AccountDto resultAcc;

    @Before
    public void setUp() throws Exception {
        when(accTranslator.create(any(AccountDto.class))).then(returnsFirstArg());
        resultAcc = accService.create(new AccountDto());
    }

    @After
    public void tearDown() throws Exception {
        resultAcc = null;
    }

    @Test
    public void create() throws SQLException {
        when(accTranslator.create(any(AccountDto.class))).then(returnsFirstArg());
        AccountDto resultAcc = accService.create(new AccountDto());
        assertNotNull(resultAcc); // test if account is created
        assertNotNull(resultAcc.getAccountNumber()); // test if account has a number to uniquely identify it
        assertTrue(resultAcc.getType().equalsIgnoreCase("MILES") || resultAcc.getType().equalsIgnoreCase("PLAYS") || resultAcc.getType().equalsIgnoreCase("RANDS"));
        // test if account type is valid
        verify(accTranslator, atLeastOnce()).create(any(AccountDto.class));
    }

    @Test
    public void getBalanceByAccNum() throws SQLException {
        assertNotNull(resultAcc);
        double balance = accService.getBalanceByAccNum(resultAcc.getAccountNumber());
        assertNotNull(balance);
    }

    @Test
    public void getByAccountNumber() throws SQLException {
        assertNotNull(resultAcc);
        when(accTranslator.getByAccountNumber(resultAcc.getAccountNumber())).thenReturn(resultAcc);
        AccountDto acc = accService.getByAccountNumber(resultAcc.getAccountNumber());
        assertNotNull(acc);
        verify(accTranslator,atLeastOnce()).getByAccountNumber(resultAcc.getAccountNumber());
    }

    @Test
    public void updateBalanceByAccNum() throws SQLException {
        assertNotNull(resultAcc);
        accService.updateBalanceByAccNum(resultAcc.getAccountNumber(),150);
        verify(accTranslator, atLeastOnce()).updateBalanceByAccNum(resultAcc.getAccountNumber(),150);
    }
}