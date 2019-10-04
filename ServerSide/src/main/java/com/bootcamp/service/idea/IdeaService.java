package com.bootcamp.service.idea;

import com.bootcamp.dto.IdeaDTO;

public interface IdeaService {

    /**
     * THis method adds a new Idea into the database
     *
     * @return The IdeaDTO containing the new Idea
     */
    IdeaDTO insertIdea(IdeaDTO ideaDTO, Integer hackathonId);


    /**
     * This method allows one to edit an idea using Idea Id
     *
     * @return The IdeaDTO containing the new Idea
     */
    IdeaDTO editIdea(int ideaId, IdeaDTO ideaDTO);

}
