package com.bootcamp.controller;

import com.bootcamp.dto.IdeaDTO;
import com.bootcamp.service.idea.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping(value = "/hackathons")
public class IdeaController {

    @Autowired
    private IdeaService service;

    @PostMapping(value = "/{hackathonId}/ideas")
    public IdeaDTO submitIdea(@PathVariable int hackathonId, @Valid @RequestBody IdeaDTO ideaDTO) {
        return service.insertIdea(ideaDTO, hackathonId);
    }

    @PutMapping(value = "/ideas/{ideaId}")
    public IdeaDTO editIdea(@PathVariable int ideaId, @Valid @RequestBody IdeaDTO ideaDTO) {
        return service.editIdea(ideaId, ideaDTO);
    }
}
