package com.bootcamp.service.idea;

import com.bootcamp.dto.IdeaDTO;
import com.bootcamp.errorhandling.ResourceNotFoundException;
import com.bootcamp.model.Idea;
import com.bootcamp.repository.HackathonRepository;
import com.bootcamp.repository.IdeaRepository;
import com.bootcamp.transformer.IdeaTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IdeaServiceImpl implements IdeaService {

    private static final Logger LOG = LoggerFactory.getLogger(IdeaServiceImpl.class);

    @Autowired
    private HackathonRepository hackathonRepository;

    @Autowired
    private IdeaRepository ideaRepository;

    @Autowired
    private IdeaTransformer ideaTransformer;


    @Override
    public IdeaDTO insertIdea(IdeaDTO ideaDTO, Integer hackathonId) {
        LOG.info("Inserting new Idea into Database");
        Idea ideaEntity = new Idea();
        ideaEntity = ideaTransformer.toEntity(ideaDTO, ideaEntity);
        ideaEntity.setHackathonId(hackathonId);
        LOG.info("Saving new Idea Entity with given data");
        Idea resultIdeaEntity = ideaRepository.save(ideaEntity);

        return ideaTransformer.toDTO(resultIdeaEntity);
    }

    @Override
    public IdeaDTO editIdea(int ideaId, IdeaDTO ideaDTO) {
        LOG.info("Getting idea with ID " + ideaId);
        Idea ideaEntity = ideaRepository.findById(ideaId).orElseThrow(() -> new ResourceNotFoundException("No Idea with Id " + ideaId));
        ideaEntity = ideaTransformer.toEntity(ideaDTO, ideaEntity);
        LOG.info("Saving Edited Idea");
        Idea resultIdeaEntity = ideaRepository.save(ideaEntity);

        return ideaTransformer.toDTO(resultIdeaEntity);
    }

}
