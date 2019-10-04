package com.bootcamp.repository;

import com.bootcamp.model.Hackathon;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HackathonRepositorytest {

    @Autowired
    HackathonRepository hackathonRepository;

    @Test
    public void getHackathonsTest() {
        List<Hackathon> hackathonList = new ArrayList<>();
        hackathonList = hackathonRepository.findAll();
        Assert.assertEquals("Bolt 2018", hackathonList.get(0).getEventName());
        Assert.assertEquals("Hackfest 2017", hackathonList.get(1).getEventName());
        Assert.assertEquals("Codeathon 2016", hackathonList.get(2).getEventName());
    }

}
