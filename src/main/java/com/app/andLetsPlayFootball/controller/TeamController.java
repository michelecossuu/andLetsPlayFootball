package com.app.andLetsPlayFootball.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.andLetsPlayFootball.dto.TeamDTO;
import com.app.andLetsPlayFootball.mapper.TeamMapper;
import com.app.andLetsPlayFootball.model.Team;
import com.app.andLetsPlayFootball.service.TeamService;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    Logger logger = Logger.getLogger(TeamController.class.getName());

    private final TeamService teamService;
    private final TeamMapper mapper;

    public TeamController(TeamService teamService, TeamMapper mapper) {
        this.teamService = teamService;
        this.mapper = mapper;
    }

    @GetMapping("/search")
    public ResponseEntity<List<TeamDTO>> searchTeams(@RequestParam("name") String name) {
        List<Team> teams = teamService.searchTeams(name);
        List<TeamDTO> teamsDTO = new ArrayList<>();
        for (Team t : teams) {
            teamsDTO.add(mapper.teamToTeamDTO(t));
        }
        return ResponseEntity.ok(teamsDTO);
    }
    
}
