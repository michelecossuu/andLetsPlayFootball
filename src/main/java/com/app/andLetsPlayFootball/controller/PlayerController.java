package com.app.andLetsPlayFootball.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.andLetsPlayFootball.dto.PlayerDTO;
import com.app.andLetsPlayFootball.mapper.PlayerMapper;
import com.app.andLetsPlayFootball.model.Player;
import com.app.andLetsPlayFootball.service.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/players")
public class PlayerController {

    Logger logger = Logger.getLogger(PlayerController.class.getName());
    
    private final PlayerService playerService;
    private final PlayerMapper mapper;

    public PlayerController(PlayerService playerService, PlayerMapper mapper) {
        this.playerService = playerService;
        this.mapper = mapper;
    }

    @GetMapping("/search")
    public ResponseEntity<List<PlayerDTO>> searchPlayers(@RequestParam("surname") String surname) {
        List<Player> players = playerService.searchPlayers(surname);
        List<PlayerDTO> playersDTO = new ArrayList<>();
        for (Player p : players) {
            playersDTO.add(mapper.playerToPlayerDTO(p));
        }
        return ResponseEntity.ok(playersDTO);
    }
    

}
