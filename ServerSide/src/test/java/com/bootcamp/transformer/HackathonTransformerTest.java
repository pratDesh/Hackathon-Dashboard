package com.bootcamp.transformer;

import com.bootcamp.dto.HackathonDTO;
import com.bootcamp.model.Hackathon;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HackathonTransformerTest {

    @Autowired
    HackathonTransformer hackathonTransformer;

    @Test
    public void entityToDTOTest() {
        Hackathon hackathon = new Hackathon();
        hackathon.setEventName("Event 2020");

        List<Hackathon> hackathonList = new ArrayList<>();
        hackathonList.add(hackathon);
        List<HackathonDTO> hackathonDTOList = new ArrayList<>();

        hackathonDTOList = hackathonTransformer.toDTOList(hackathonList);

        Assert.assertEquals("Event 2020", hackathonDTOList.get(0).getEventName());
    }
}
