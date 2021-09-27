package za.ac.nwu.as.web.sb.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import za.ac.nwu.as.domain.dto.AccountDto;
import za.ac.nwu.as.domain.dto.TransactionDto;
import za.ac.nwu.as.logic.service.AccountService;
import za.ac.nwu.as.logic.service.TransactionService;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class TransactionControllerTest {

    private static final String APP_URL = "/account-system/mvc";
    private static final String TRANSACTION_CONTROLLER_URL = APP_URL + "/transaction/";

    @Mock
    private TransactionService transService;

    @InjectMocks
    private TransactionController transController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(transController).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
        String exResponse = "{\"successful\":true,\"data\":[{\"transactionID\":1,\"accountNumber\":1,\"amount\":100.0,\"transactionDate\":[2021,8,28]}," +
                "{\"transactionID\":2,\"accountNumber\":2,\"amount\":-50.0,\"transactionDate\":[2021,8,30]}]}";

        List<TransactionDto> transactions = new ArrayList<>();
        transactions.add(new TransactionDto(1,1,100, LocalDate.parse("2021-08-28")));
        transactions.add(new TransactionDto(2,2,-50, LocalDate.parse("2021-08-30")));

        when(transService.getAllTransactions()).thenReturn(transactions);

        MvcResult mvcResult = mockMvc.perform(get((String.format("%s%s",TRANSACTION_CONTROLLER_URL,"all")))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        verify(transService, times(1)).getAllTransactions();
        assertEquals(exResponse,mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void create() throws Exception {
        String newTrans = "{\"transactionID\":1,\"accountNumber\":1,\"amount\":100.0,\"transactionDate\":[2021,8,28]}}";
        String exResponse = "{\"successful\":true,\"data\":{\"transactionID\":1,\"accountNumber\":1,\"amount\":100.0,\"transactionDate\":[2021,8,28]}}";

        TransactionDto trans = new TransactionDto(1,1,100,LocalDate.parse("2021-08-28"));
        when(transService.create(eq(trans))).then(returnsFirstArg());

        MvcResult mvcResult = mockMvc.perform(post(TRANSACTION_CONTROLLER_URL)
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(newTrans)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        verify(transService, times(1)).create(eq(trans));
        assertEquals(exResponse, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getTransactionByAccNum() throws Exception {
        String exResponse = "{\"successful\":true,\"data\":[{\"transactionID\":1,\"accountNumber\":1,\"amount\":100.0,\"transactionDate\":[2021,8,28]}," +
                "{\"transactionID\":2,\"accountNumber\":1,\"amount\":-50.0,\"transactionDate\":[2021,8,30]}]}";

        List<TransactionDto> transactions = new ArrayList<>();
        TransactionDto trans = new TransactionDto(1,1,100, LocalDate.parse("2021-08-28"));
        transactions.add(trans);
        transactions.add(new TransactionDto(2,1,-50, LocalDate.parse("2021-08-30")));
        when(transService.getTransactionByAccountNumber(1)).thenReturn(transactions);

        MvcResult mvcResult = mockMvc.perform(get((String.format("%s%s/%s",TRANSACTION_CONTROLLER_URL,"getTransactionByAccountNum",trans.getAccountNumber())))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        verify(transService, times(1)).getTransactionByAccountNumber(1);
        assertEquals(exResponse,mvcResult.getResponse().getContentAsString());
    }
}