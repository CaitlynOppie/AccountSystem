package za.ac.nwu.as.logic.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.as.domain.dto.MemberDto;
import za.ac.nwu.as.translator.flow.MemberTranslator;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Test
    public void create() {

//        when(memTranslator.create(any(MemberDto.class))).thenReturn(null);
//        MemberDto result = memService.create(new MemberDto());
//        assertNull(result);
//        verify(memTranslator).create(any(MemberDto.class));
    }
}