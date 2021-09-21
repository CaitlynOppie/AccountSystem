package za.ac.nwu.as.logic.service.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.as.domain.dto.MemberDto;
import za.ac.nwu.as.domain.persistence.Member;
import za.ac.nwu.as.translator.flow.MemberTranslator;

import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateMemberServiceImplTest {

    @Mock
    private MemberTranslator memTranslator;

    @InjectMocks
    private CreateMemberServiceImpl memService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    //How to write test with create and update in one?

    @Test
    public void create() throws SQLException {
//            when(memTranslator.create(any(MemberDto.class))).then(returnsFirstArg());
//            MemberDto resultMem = memService.create(new MemberDto());
//            assertNotNull(resultMem); // test if member is created
//            assertNotNull(resultMem.getMemberID()); // test if member has an ID
//            assertEquals(10, resultMem.getMemPhone().length()); // test if phone number provided is 10 characters long
//            assertTrue(resultMem.getMemEmail().contains("@")); // test if valid email is provided
//            verify(memTranslator, atLeastOnce()).create(any(MemberDto.class));
    }
}