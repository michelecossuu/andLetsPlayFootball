package com.app.andLetsPlayFootball.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.andLetsPlayFootball.dto.PlayerDTO;
import com.app.andLetsPlayFootball.service.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/players")
public class PlayerController {

    Logger logger = Logger.getLogger(PlayerController.class.getName());
    
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<PlayerDTO>> searchPlayers(@RequestParam("surname") String surname) {
        List<PlayerDTO> playersDTO = playerService.searchPlayers(surname);
        return ResponseEntity.ok(playersDTO);
    }

}
