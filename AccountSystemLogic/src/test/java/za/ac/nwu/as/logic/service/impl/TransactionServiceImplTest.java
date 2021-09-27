package za.ac.nwu.as.logic.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.as.domain.dto.AccountDto;
import za.ac.nwu.as.domain.dto.TransactionDto;
import za.ac.nwu.as.translator.flow.AccountTranslator;
import za.ac.nwu.as.translator.flow.TransactionTranslator;

import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceImplTest {
    @Mock
    private AccountTranslator accountTranslator;

    @Mock
    private TransactionTranslator transTranslator;

    @InjectMocks
    private TransactionServiceImpl transService;

    @Before
    public void setUp() throws Exception {
        lenient().when(transTranslator.create(any(TransactionDto.class))).then(returnsFirstArg());
        lenient().when(accountTranslator.create(any(AccountDto.class))).then(returnsFirstArg());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() throws SQLException {
        when(transTranslator.create(any(TransactionDto.class))).then(returnsFirstArg());
        TransactionDto resultTrans = transService.create(new TransactionDto());
        assertNotNull(resultTrans); // test if transaction is created
        assertNotNull(resultTrans.getTransactionID()); // test if transaction has an ID to uniquely identify it
        assertNotEquals(0,resultTrans.getAmount()); // tests if provided amount is valid (either positive or negative)
        verify(transTranslator, atLeastOnce()).create(any(TransactionDto.class));
    }
}