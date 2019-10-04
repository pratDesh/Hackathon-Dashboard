package com.bootcamp.service.hackathon;


import com.bootcamp.dto.HackathonDTO;
import com.bootcamp.errorhandling.ResourceNotFoundException;
import com.bootcamp.model.Hackathon;
import com.bootcamp.repository.HackathonRepository;
import com.bootcamp.transformer.HackathonTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HackathonServiceImpl implements HackathonService {

    private static final Logger LOG = LoggerFactory.getLogger(HackathonServiceImpl.class);

    @Autowired
    private HackathonRepository hackathonRepository;

    @Autowired
    private HackathonTransformer hackathonTransformer;

    @Override
    public List<HackathonDTO> getHackathons() {
        LOG.info("Getting all hackathon list");
        List<Hackathon> hackathons = hackathonRepository.findAll(Sort.by("eventName").ascending());
        LOG.info("Retrieved " + hackathons.size() + " hackathons form database");

        return hackathonTransformer.toDTOList(hackathons);
    }

    @Override
    public HackathonDTO getHackathonById(int hackathonId) {
        LOG.info("Getting Hackathon with Id " + hackathonId);
        Hackathon hackathon = hackathonRepository.findById(hackathonId).orElseThrow(() -> new ResourceNotFoundException("No Hackathon with id " + hackathonId));

        return hackathonTransformer.toDTO(hackathon);
    }

}
