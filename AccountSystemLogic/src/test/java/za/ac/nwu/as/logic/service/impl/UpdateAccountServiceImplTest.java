package za.ac.nwu.as.logic.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.as.domain.dto.AccountDto;
import za.ac.nwu.as.domain.dto.MemberDto;
import za.ac.nwu.as.domain.persistence.Account;
import za.ac.nwu.as.domain.persistence.Member;
import za.ac.nwu.as.translator.flow.AccountTranslator;
import za.ac.nwu.as.translator.flow.TransactionTranslator;

import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UpdateAccountServiceImplTest {

    @Mock
    private AccountTranslator accTranslator;

    @InjectMocks
    private CreateAccountServiceImpl createAccountService;

    @InjectMocks
    private UpdateAccountServiceImpl accService;


    AccountDto resultAcc;

    @Before
    public void setUp() throws Exception {
        when(accTranslator.create(any(AccountDto.class))).then(returnsFirstArg());
        resultAcc = createAccountService.create(new AccountDto());
    }

    @After
    public void tearDown() throws Exception {
        resultAcc = null;
    }

    @Test
    public void updateBalanceByAccNum() throws SQLException {
        assertNotNull(resultAcc);
        accService.updateBalanceByAccNum(resultAcc.getAccountNumber(),150);
        verify(accTranslator, atLeastOnce()).updateBalanceByAccNum(resultAcc.getAccountNumber(),150);
    }
}