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
import za.ac.nwu.as.domain.persistence.Member;
import za.ac.nwu.as.translator.flow.AccountTranslator;

import java.sql.SQLException;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UpdateAccountServiceImplTest {

    @Mock
    private AccountTranslator accTranslator;

    @InjectMocks
    private UpdateAccountServiceImpl accService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    // how to write unit test for update?
    @Test
    public void updateBalanceByAccNum() throws SQLException {
//        AccountDto resultAcc = new AccountDto(1,new MemberDto(new Member(1)),"MILES",100);
//        double balanceBefore = accTranslator.getBalanceByAccNum(resultAcc.getAccountNumber()).getBalance();
//        accTranslator.updateBalanceByAccNum(resultAcc.getAccountNumber(), 100);
//        double balanceAfter = accTranslator.getBalanceByAccNum(resultAcc.getAccountNumber()).getBalance();
//        assertTrue(balanceBefore != balanceAfter);
    }
}