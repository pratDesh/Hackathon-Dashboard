package com.bootcamp.transformer;

import com.bootcamp.dto.IdeaDTO;
import com.bootcamp.model.Idea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IdeaTransformer {

    private static final Logger LOG = LoggerFactory.getLogger(IdeaTransformer.class);

    public List<IdeaDTO> toDTOList(List<Idea> ideas) {
        LOG.info("Converting a list of Idea Entity to list of Idea DTO");
        List<IdeaDTO> ideaDTOs = new ArrayList<>();
        for (Idea idea : ideas) {
            IdeaDTO ideaDTO = new IdeaDTO();
            ideaDTO = toDTO(idea);
            ideaDTOs.add(ideaDTO);
        }
        return ideaDTOs;
    }


    public Idea toEntity(IdeaDTO ideaDTO, Idea idea) {
        LOG.info("Converting Idea DTO to Idea Entity");
        idea.setDetails(ideaDTO.getDetails());
        idea.setSummary(ideaDTO.getSummary());
        idea.setCategory(ideaDTO.getCategory());
        idea.setTeamMembers(ideaDTO.getTeamMembers());
        idea.setLikes(ideaDTO.getLikes());

        return idea;
    }

    public IdeaDTO toDTO(Idea idea) {
        LOG.info("Converting Idea Entity to Idea DTO");
        IdeaDTO ideaDTO = new IdeaDTO();
        ideaDTO.setId(idea.getId());
        ideaDTO.setDetails(idea.getDetails());
        ideaDTO.setSummary(idea.getSummary());
        ideaDTO.setCategory(idea.getCategory());
        ideaDTO.setTeamMembers(idea.getTeamMembers());
        ideaDTO.setLikes(idea.getLikes());

        return ideaDTO;
    }
}


