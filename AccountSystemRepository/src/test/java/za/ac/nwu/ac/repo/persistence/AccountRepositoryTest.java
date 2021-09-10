package za.ac.nwu.ac.repo.persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.nwu.as.domain.dto.AccountDto;
import za.ac.nwu.as.domain.persistence.Account;

import static org.junit.Assert.*;

public class AccountRepositoryTest {

    @Autowired
    private AccountRepository repo;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shouldGetByAccountNumber() {
        //given

        //when

        //then
    }

    @Test
    public void shouldGetBalanceByAccNum() {
        //given

        //when

        //then
    }

    @Test
    public void shouldUpdateBalanceByAccNum() {
        //given

        //when

        //then
    }
}