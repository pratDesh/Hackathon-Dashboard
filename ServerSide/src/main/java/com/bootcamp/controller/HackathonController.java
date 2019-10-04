package com.bootcamp.controller;

import com.bootcamp.dto.HackathonDTO;
import com.bootcamp.service.hackathon.HackathonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/hackathons")
public class HackathonController {

    @Autowired
    private HackathonService service;

    @GetMapping(value = "")
    public List<HackathonDTO> getHackathons() {
        return service.getHackathons();
    }

    @GetMapping(value = "/{hackathonId}/ideas")
    public HackathonDTO getHackathonById(@PathVariable int hackathonId) {
        return service.getHackathonById(hackathonId);
    }
}
