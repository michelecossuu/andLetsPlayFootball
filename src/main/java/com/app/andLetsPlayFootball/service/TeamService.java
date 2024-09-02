package com.app.andLetsPlayFootball.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.andLetsPlayFootball.model.Team;
import com.app.andLetsPlayFootball.repository.TeamRepository;

@Service
public class TeamService {
    
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> searchTeams(String name) {
        return teamRepository.findByNameContainingIgnoreCase(name);
    }

}
