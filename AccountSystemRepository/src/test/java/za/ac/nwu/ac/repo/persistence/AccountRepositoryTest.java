package za.ac.nwu.ac.repo.persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.nwu.ac.repo.config.RepositoryTestConfig;
import za.ac.nwu.as.domain.persistence.Account;
import za.ac.nwu.as.domain.persistence.Member;

import static org.junit.Assert.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;


@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {RepositoryTestConfig.class})
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accRepo;

    @Autowired
    MemberRepository memRepo;

    @Before
    public void setUp() throws Exception {
//        memRepo.save(new Member(1,"Caitlyn","Opperman","ceopperman@gmail.com","0714587895"));
//        accRepo.save(new Account(1,1,"MILES",250));
    }

    @After
    public void tearDown() throws Exception {
//        memRepo.deleteAll();
//        accRepo.deleteAll();
    }

    @Test
    public void getByAccountNumber() {
        Account resultAcc = accRepo.getByAccountNumber(1);
        assertNotNull(resultAcc);
    }

    @Test
    public void getBalanceByAccNum() {
        double balance = accRepo.getBalanceByAccNum(1);
        assertNotNull(balance);
    }

    @Test
    public void updateBalanceByAccNum() {
        double balanceNew = accRepo.getBalanceByAccNum(1);
        accRepo.updateBalanceByAccNum(1,250);
        double balanceAfter = accRepo.getBalanceByAccNum(1);
        assertNotEquals(balanceNew,balanceAfter);
    }

}