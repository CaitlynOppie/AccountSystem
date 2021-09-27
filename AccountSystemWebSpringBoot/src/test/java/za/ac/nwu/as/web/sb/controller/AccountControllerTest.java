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
import za.ac.nwu.as.logic.service.AccountService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    private static final String APP_URL = "/account-system/mvc";
    private static final String ACCOUNT_CONTROLLER_URL = APP_URL + "/account/";

    @Mock
    private AccountService accService;

    @InjectMocks
    private AccountController accController;

    private MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(accController).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() throws Exception {
        String newAcc = "{\"accountNumber\":3,\"memberID\": 1,\"type\":\"MILES\",\"balance\": 250}}";
        String exResponse = "{\"successful\":true,\"data\":{\"accountNumber\":3,\"memberID\":1,\"type\":\"MILES\",\"balance\":250.0}}";

        AccountDto acc = new AccountDto(3,1,"MILES",250);
        when(accService.create(eq(acc))).then(returnsFirstArg());

        MvcResult mvcResult = mockMvc.perform(post(ACCOUNT_CONTROLLER_URL)
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(newAcc)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        verify(accService, times(1)).create(eq(acc));
        assertEquals(exResponse, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getAll() throws Exception{
        String exResponse = "{\"successful\":true,\"data\":[{\"accountNumber\":3,\"memberID\":1,\"type\":\"MILES\",\"balance\":250.0}," +
                "{\"accountNumber\":4,\"memberID\":2,\"type\":\"MILES\",\"balance\":100.0}]}";

        List<AccountDto> accounts = new ArrayList<>();
        accounts.add(new AccountDto(3,1,"MILES",250));
        accounts.add(new AccountDto(4,2,"MILES",100));

        when(accService.getAllAccounts()).thenReturn(accounts);

        MvcResult mvcResult = mockMvc.perform(get((String.format("%s%s",ACCOUNT_CONTROLLER_URL,"all")))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        verify(accService, times(1)).getAllAccounts();
        assertEquals(exResponse,mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getBalanceByAccNum() throws Exception {
        String exResponse = "{\"successful\":true,\"data\":150.0}";
        AccountDto newAcc = new AccountDto(1,1,"MILES",150);

        when(accService.getBalanceByAccNum(newAcc.getAccountNumber())).thenReturn(newAcc.getBalance());

        MvcResult mvcResult = mockMvc.perform(get((String.format("%s%s/%s",ACCOUNT_CONTROLLER_URL,"getBalanceByAccNum",newAcc.getAccountNumber())))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        verify(accService, times(1)).getBalanceByAccNum(newAcc.getAccountNumber());
        assertEquals(exResponse,mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getByAccNum() throws Exception {
        String exResponse = "{\"successful\":true,\"data\":{\"accountNumber\":5,\"memberID\":3,\"type\":\"MILES\",\"balance\":150.0}}";
        AccountDto newAcc = new AccountDto(5,3,"MILES",150);

        when(accService.getByAccountNumber(newAcc.getAccountNumber())).thenReturn(newAcc);

        MvcResult mvcResult = mockMvc.perform(get((String.format("%s%s/%s",ACCOUNT_CONTROLLER_URL,"getByAccNum",newAcc.getAccountNumber())))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        verify(accService, times(1)).getByAccountNumber(newAcc.getAccountNumber());
        assertEquals(exResponse,mvcResult.getResponse().getContentAsString());
    }
}