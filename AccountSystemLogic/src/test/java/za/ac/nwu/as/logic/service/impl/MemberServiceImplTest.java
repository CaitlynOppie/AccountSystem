package za.ac.nwu.as.logic.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.as.domain.dto.MemberDto;
import za.ac.nwu.as.translator.flow.MemberTranslator;

import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceImplTest {

    @Mock
    private MemberTranslator memTranslator;

    @InjectMocks
    private MemberServiceImpl memService;

    MemberDto newMem;

    @Before
    public void setUp() throws Exception {
        when(memTranslator.create(any(MemberDto.class))).then(returnsFirstArg());
        newMem = memService.create(new MemberDto(1,"Caitlyn","Opperman","ceopperman@gmail.com","0717898426"));
    }

    @After
    public void tearDown() throws Exception {
        newMem = null;
    }


    @Test
    public void create() throws SQLException {
        when(memTranslator.create(any(MemberDto.class))).then(returnsFirstArg());
        MemberDto resultMem = memService.create(new MemberDto());
        assertNotNull(resultMem); // test if member is created
        assertNotNull(resultMem.getMemberID()); // test if member has an ID
        assertEquals(10, resultMem.getMemPhone().length()); // test if phone number provided is 10 characters long
        assertTrue(resultMem.getMemEmail().contains("@")); // test if valid email is provided
        verify(memTranslator, atLeastOnce()).create(any(MemberDto.class));
    }

    @Test
    public void getMemberByID() throws SQLException {
        assertNotNull(newMem);
        when(memTranslator.getMemberByID(newMem.getMemberID())).thenReturn(newMem);
        MemberDto mem = memService.getMemberByID(newMem.getMemberID());
        assertNotNull(mem);
        verify(memTranslator, atLeastOnce()).getMemberByID(newMem.getMemberID());
    }
}