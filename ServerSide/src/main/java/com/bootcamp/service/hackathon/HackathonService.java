package com.bootcamp.service.hackathon;

import com.bootcamp.dto.HackathonDTO;

import java.util.List;

public interface HackathonService {

    /**
     * Method gets the list of all the hackathons in MO database in ascending order
     *
     * @return List of HackathonDTO
     */
    public List<HackathonDTO> getHackathons();

    /**
     * Method gets hackathon from database with given Id
     *
     * @return List of HackathonDTO
     */
    public HackathonDTO getHackathonById(int hackathonId);

}
