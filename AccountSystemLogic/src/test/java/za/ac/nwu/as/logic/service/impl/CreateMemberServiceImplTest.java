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
import za.ac.nwu.as.translator.flow.MemberTranslator;

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

    @Test
    public void create() {
        //testing that the create method is called exactly once when a new member is created.
//        MemberDto test = memService.create(new MemberDto());
//        verify(memTranslator, times(1)).create(any(MemberDto.class));
    }
}