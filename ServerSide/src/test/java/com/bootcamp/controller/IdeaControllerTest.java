package com.bootcamp.controller;


import com.bootcamp.service.idea.IdeaService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(IdeaController.class)
public class IdeaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IdeaService ideaService;

}
