package com.bootcamp.service;

import com.bootcamp.dto.IdeaDTO;
import com.bootcamp.model.Idea;
import com.bootcamp.repository.HackathonRepository;
import com.bootcamp.repository.IdeaRepository;
import com.bootcamp.service.idea.IdeaServiceImpl;
import com.bootcamp.transformer.IdeaTransformer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IdeaServiceTest {

    @Mock
    private HackathonRepository hackathonRepository;

    @Mock
    private IdeaRepository ideaRepository;

    @Mock
    private IdeaTransformer ideaTransformer;

    @InjectMocks
    private IdeaServiceImpl ideaService;

    private Idea idea;
    private List<Idea> ideaList;
    private IdeaDTO ideaDTO;
    private List<IdeaDTO> ideaDTOList;

    @Before
    public void setUp() {

        idea = new Idea();
        idea.setId(1);
        idea.setHackathonId(1);
        idea.setSummary("Summary");
        idea.setDetails("Idea Details");
        idea.setCategory("Domain");
        idea.setTeamMembers("Dave");
        idea.setLikes(5);

        ideaList = new ArrayList<>();
        ideaList.add(idea);

        ideaDTO = new IdeaDTO();
        ideaDTO.setId(1);
        ideaDTO.setSummary("Summary");
        ideaDTO.setDetails("Idea Details");
        ideaDTO.setCategory("Domain");
        ideaDTO.setTeamMembers("Dave");
        ideaDTO.setLikes(5);

        ideaDTOList = new ArrayList<>();
        ideaDTOList.add(ideaDTO);
    }


    @Test
    public void insertIdeaTest() {
        when(ideaTransformer.toEntity(Mockito.any(IdeaDTO.class), Mockito.any(Idea.class))).thenReturn(idea);
        when(ideaRepository.save(Mockito.any(Idea.class))).thenReturn(idea);
        when(ideaTransformer.toDTO(Mockito.any(Idea.class))).thenReturn(ideaDTO);

        IdeaDTO underTest = new IdeaDTO();
        underTest = ideaService.insertIdea(ideaDTO, 1);

        Assert.assertEquals("Summary", underTest.getSummary());
        Assert.assertEquals(5, underTest.getLikes());
    }

    @Test
    public void editIdeaTest() {
        when(ideaRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(idea));
        when(ideaTransformer.toEntity(Mockito.any(IdeaDTO.class), Mockito.any(Idea.class))).thenReturn(idea);
        when(ideaRepository.save(Mockito.any(Idea.class))).thenReturn(idea);
        when(ideaTransformer.toDTO(Mockito.any(Idea.class))).thenReturn(ideaDTO);

        IdeaDTO underTest = new IdeaDTO();
        underTest = ideaService.editIdea(1, ideaDTO);

        Assert.assertEquals("Summary", underTest.getSummary());
        Assert.assertEquals(1, underTest.getId());

    }
}
