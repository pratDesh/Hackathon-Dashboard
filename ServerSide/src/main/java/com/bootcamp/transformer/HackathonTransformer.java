package com.bootcamp.transformer;

import com.bootcamp.dto.HackathonDTO;
import com.bootcamp.model.Hackathon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class HackathonTransformer {

    @Autowired
    IdeaTransformer ideaTransformer;

    private static final Logger LOG = LoggerFactory.getLogger(HackathonTransformer.class);

    public List<HackathonDTO> toDTOList(List<Hackathon> hackathons) {
        LOG.info("Converting List of Hackathon Entity to List of Hackathon DTO");

        List<HackathonDTO> hackathonDTOs = new ArrayList<>();
        for (int counter = 0; counter < hackathons.size(); counter++) {
            HackathonDTO hackathonDTO = toDTO(hackathons.get(counter));
            hackathonDTOs.add(hackathonDTO);
        }
        return hackathonDTOs;
    }

    public HackathonDTO toDTO(Hackathon hackathon) {
        HackathonDTO hackathonDTO = new HackathonDTO();
        hackathonDTO.setId(hackathon.getId());
        hackathonDTO.setMoOffice(hackathon.getMoOffice());
        hackathonDTO.setEventName(hackathon.getEventName());
        hackathonDTO.setDateConducted(hackathon.getDateConducted());
        hackathonDTO.setTotalIdeas(hackathon.getTotalIdeas());
        hackathonDTO.setIdeaDTOs(ideaTransformer.toDTOList(hackathon.getIdeas()));

        return hackathonDTO;
    }
}


