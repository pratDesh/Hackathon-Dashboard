package com.bootcamp.transformer;

import com.bootcamp.dto.IdeaDTO;
import com.bootcamp.model.Idea;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IdeaTransformerTest {
    @Autowired
    IdeaTransformer ideaTransformer;

    Idea idea;
    IdeaDTO ideaDTO;
    List<Idea> ideaList;

    @Before
    public void instantiateObjects() {
        idea = new Idea();
        idea.setSummary("Short Summary");
        idea.setDetails("Detailed idea Description");
        idea.setId(1);
        idea.setTeamMembers("Member");
        idea.setLikes(5);
        idea.setHackathonId(1);
        idea.setCategory("Domain");

        ideaDTO = new IdeaDTO();
        ideaDTO.setSummary("summary of Idea");
        ideaDTO.setDetails("The beauty is in the Details");
        ideaDTO.setId(2);
        ideaDTO.setLikes(10);
        ideaDTO.setCategory("Technology");
        ideaDTO.setTeamMembers("Steve");

        ideaList = new ArrayList<>();
        ideaList.add(idea);
    }


    @Test
    public void entityToDTOTest() {
        IdeaDTO underTest = new IdeaDTO();
        underTest = ideaTransformer.toDTO(idea);
        Assert.assertEquals(idea.getCategory(), underTest.getCategory());
        Assert.assertEquals(idea.getSummary(), underTest.getSummary());
        Assert.assertEquals(idea.getTeamMembers(), underTest.getTeamMembers());
    }

    @Test
    public void dtoToEntity() {
        Idea underTest = new Idea();
        ideaTransformer.toEntity(ideaDTO, underTest);
        Assert.assertEquals(ideaDTO.getCategory(), underTest.getCategory());
        Assert.assertEquals(ideaDTO.getSummary(), underTest.getSummary());
    }

    @Test
    public void entityListToDTOListTest() {
        List<IdeaDTO> ideaDTOList = new ArrayList<>();
        ideaDTOList = ideaTransformer.toDTOList(ideaList);
        Assert.assertEquals(1, ideaDTOList.size());
        Assert.assertEquals("Short Summary", ideaDTOList.get(0).getSummary());
        Assert.assertEquals(5, ideaDTOList.get(0).getLikes());

    }

}
