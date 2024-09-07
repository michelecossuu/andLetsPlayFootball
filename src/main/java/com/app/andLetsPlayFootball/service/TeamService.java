package com.app.andLetsPlayFootball.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.andLetsPlayFootball.dto.TeamDTO;
import com.app.andLetsPlayFootball.mapper.TeamMapper;
import com.app.andLetsPlayFootball.model.Team;
import com.app.andLetsPlayFootball.repository.TeamRepository;

@Service
public class TeamService {
    
    private final TeamRepository teamRepository;
    private final TeamMapper mapper;

    public TeamService(TeamRepository teamRepository, TeamMapper mapper) {
        this.teamRepository = teamRepository;
        this.mapper = mapper;
    }

    public List<TeamDTO> searchTeams(String name) {
        List<Team> teams = teamRepository.findByNameContainingIgnoreCase(name);
        List<TeamDTO> teamsDTO = new ArrayList<>();
        for (Team t : teams) {
            teamsDTO.add(mapper.teamToTeamDTO(t));
        }
        return teamsDTO;
    }

}
