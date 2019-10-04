package com.bootcamp.repository;


import com.bootcamp.model.Idea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdeaRepository extends JpaRepository<Idea, Integer> {
    List<Idea> findAllByHackathonId(Integer hackathonId);
}
