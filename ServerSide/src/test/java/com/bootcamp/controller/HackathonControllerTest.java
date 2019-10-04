package com.bootcamp.controller;

import com.bootcamp.dto.HackathonDTO;
import com.bootcamp.service.hackathon.HackathonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HackathonController.class)
public class HackathonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    HackathonService hackathonService;

    @Test
    public void getHackathonTest() throws Exception {

        List<HackathonDTO> hackathonDTOList = new ArrayList<>();
        given(hackathonService.getHackathons()).willReturn(hackathonDTOList);

        MockHttpServletResponse response = mockMvc.perform(get("/hackathons")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse();
    }


    @Test
    public void getHackathonByIdTest() throws Exception {
        HackathonDTO hackathonDTO = new HackathonDTO();

//        given(hackathonService.getHackathonById(1)).willReturn();

        MockHttpServletResponse response = mockMvc.perform(get("/hackathons/1/idea")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse();
    }

}
