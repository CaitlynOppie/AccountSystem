package za.ac.nwu.ac.repo.persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.nwu.as.domain.dto.MemberDto;
import za.ac.nwu.as.domain.persistence.Member;

import static org.junit.Assert.*;

public class MemberRepositoryTest {

    @Autowired
    private MemberRepository repo;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    //Tests if GetMemberByID query returns a member when given ID
    @Test
    public void shouldGetMemberByID() {
        //given
        Member member = new Member(
                1,
                "Caitlyn",
                "Opperman",
                "caitlyn.opperman@gmail.com",
                "0712437658"
        );
        repo.save(member);

        //when
        Member mem = repo.getMemberByID(1);

        //then
        Assert.assertNotNull(mem);
    }
}