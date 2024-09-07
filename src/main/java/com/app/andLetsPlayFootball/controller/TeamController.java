package com.app.andLetsPlayFootball.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.andLetsPlayFootball.dto.TeamDTO;
import com.app.andLetsPlayFootball.service.TeamService;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    Logger logger = Logger.getLogger(TeamController.class.getName());

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<TeamDTO>> searchTeams(@RequestParam("name") String name) {
        List<TeamDTO> teamsDTO = teamService.searchTeams(name);
        return ResponseEntity.ok(teamsDTO);
    }
    
}
