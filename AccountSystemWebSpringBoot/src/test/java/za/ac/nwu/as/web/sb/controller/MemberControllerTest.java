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
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import za.ac.nwu.as.domain.dto.MemberDto;
import za.ac.nwu.as.logic.service.MemberService;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerTest {

    private static final String APP_URL = "/account-system/mvc";
    private static final String MEMBER_CONTROLLER_URL = APP_URL + "/member/";

    @Mock
    private MemberService memService;

    @InjectMocks
    private MemberController memController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(memController).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() throws Exception {
        String newMem = "{\"memberID\":3,\"memFirstName\":\"Jay-Cee\",\"memLastName\":\"Stoltz\",\"memEmail\":\"JCStoltz@gmail.com\",\"memPhone\":\"0824507838\"}}";
        String exResponse = "{\"successful\":true,\"data\":{\"memberID\":3,\"memFirstName\":\"Jay-Cee\",\"memLastName\":\"Stoltz\",\"memEmail\":\"JCStoltz@gmail.com\",\"memPhone\":\"0824507838\"}}";

        MemberDto mem = new MemberDto("Jay-Cee","Stoltz","JCStoltz@gmail.com","0824507838");
        when(memService.create(eq(mem))).then(returnsFirstArg());

        MvcResult mvcResult = mockMvc.perform(post(MEMBER_CONTROLLER_URL)
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(newMem)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        verify(memService, times(1)).create(eq(mem));
        assertEquals(exResponse, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getAll() throws Exception {
        String exResponse = "{\"successful\":true,\"data\":[{\"memberID\":4,\"memFirstName\":\"Caitlyn\",\"memLastName\":\"Opperman\",\"memEmail\":\"ceoppermans@gmail.com\",\"memPhone\":\"0718458956\"}," +
                "{\"memberID\":5,\"memFirstName\":\"Clinton\",\"memLastName\":\"Stoltz\",\"memEmail\":\"clintonstoltz@gmail.com\",\"memPhone\":\"0114752861\"}]}";

        List<MemberDto> members = new ArrayList<>();
        members.add(new MemberDto(4,"Caitlyn","Opperman","ceoppermans@gmail.com","0718458956"));
        members.add(new MemberDto(5,"Clinton","Stoltz","clintonstoltz@gmail.com","0114752861"));

        when(memService.getAllMembers()).thenReturn(members);

        MvcResult mvcResult = mockMvc.perform(get((String.format("%s%s",MEMBER_CONTROLLER_URL,"all")))
                .servletPath(APP_URL)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        verify(memService, times(1)).getAllMembers();
        assertEquals(exResponse,mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getAccountByMemID() throws Exception {
        String exResponse = "{\"successful\":true,\"data\":{\"memberID\":4,\"memFirstName\":\"Caitlyn\",\"memLastName\":\"Opperman\",\"memEmail\":\"ceoppermans@gmail.com\",\"memPhone\":\"0718458956\"}}";
        MemberDto newMem = new MemberDto(4,"Caitlyn","Opperman","ceoppermans@gmail.com","0718458956");

        when(memService.getMemberByID(newMem.getMemberID())).thenReturn(newMem);

        MvcResult mvcResult = mockMvc.perform(get((String.format("%s%s/%s",MEMBER_CONTROLLER_URL,"getMemberByID",newMem.getMemberID())))
                .servletPath(APP_URL)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        verify(memService, times(1)).getMemberByID(newMem.getMemberID());
        assertEquals(exResponse,mvcResult.getResponse().getContentAsString());
    }
}