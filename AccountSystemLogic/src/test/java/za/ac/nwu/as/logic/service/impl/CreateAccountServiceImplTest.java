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
public class CreateAccountServiceImplTest {

    @Mock
    private AccountTranslator accTranslator;

    @InjectMocks
    private CreateAccountServiceImpl accService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
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
}