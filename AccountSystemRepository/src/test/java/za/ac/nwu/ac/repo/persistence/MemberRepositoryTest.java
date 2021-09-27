package za.ac.nwu.ac.repo.persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.nwu.ac.repo.config.RepositoryTestConfig;
import za.ac.nwu.as.domain.persistence.Member;

import static org.junit.Assert.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {RepositoryTestConfig.class})
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memRepo;

    @Before
    public void setUp() throws Exception {
        memRepo.save(new Member(1,"Caitlyn","Opperman","ceopperman@gmail.com","0714587895"));
    }

    @After
    public void tearDown() throws Exception {
        memRepo.deleteAll();
    }

    @Test
    public void shouldGetMemberByID() {
        Member resultMem = memRepo.getMemberByID(1);
        assertNotNull(resultMem);
    }
}