package com.app.andLetsPlayFootball.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.andLetsPlayFootball.model.Player;
import com.app.andLetsPlayFootball.repository.PlayerRepository;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> searchPlayers(String name) {
        return playerRepository.findByNameContainingIgnoreCase(name);
    }

}
