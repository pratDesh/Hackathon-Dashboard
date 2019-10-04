package com.bootcamp.service;

import com.bootcamp.dto.HackathonDTO;
import com.bootcamp.model.Hackathon;
import com.bootcamp.repository.HackathonRepository;
import com.bootcamp.service.hackathon.HackathonServiceImpl;
import com.bootcamp.transformer.HackathonTransformer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HackathonServiceTest {

    @Mock
    private HackathonRepository hackathonRepository;

    @Mock
    private HackathonTransformer hackathonTransformer;

    @InjectMocks
    private HackathonServiceImpl hackathonService;

    private Hackathon hackathon;
    private HackathonDTO hackathonDTO;
    private List<Hackathon> hackathonList;
    private List<HackathonDTO> hackathonDTOList;

    @Before
    public void setUp() {

        hackathon = new Hackathon();
        hackathon.setEventName("Event 2020");
        hackathon.setId(1);
        hackathon.setMoOffice("Pune");
        hackathon.setDateConducted("2019/18/5");
        hackathon.setTotalIdeas(10);

        hackathonList = new ArrayList<>();
        hackathonList.add(hackathon);

        hackathonDTO = new HackathonDTO();
        hackathonDTO.setEventName("Event 2020");
        hackathonDTO.setId(1);
        hackathonDTO.setMoOffice("Pune");
        hackathonDTO.setDateConducted("2019/18/5");
        hackathonDTO.setTotalIdeas(10);

        hackathonDTOList = new ArrayList<>();
        hackathonDTOList.add(hackathonDTO);
    }

    @Test
    public void getHackathonServiceTest() {

        when(hackathonRepository.findAll(Sort.by("eventName").ascending())).thenReturn(hackathonList);
        when(hackathonTransformer.toDTOList(hackathonList)).thenReturn(hackathonDTOList);

        Assert.assertEquals("Event 2020", hackathonService.getHackathons().get(0).getEventName());

    }

}
