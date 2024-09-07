package com.app.andLetsPlayFootball.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.andLetsPlayFootball.dto.PlayerDTO;
import com.app.andLetsPlayFootball.mapper.PlayerMapper;
import com.app.andLetsPlayFootball.model.Player;
import com.app.andLetsPlayFootball.repository.PlayerRepository;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerMapper mapper;

    public PlayerService(PlayerRepository playerRepository, PlayerMapper mapper) {
        this.playerRepository = playerRepository;
        this.mapper = mapper;
    }

    public List<PlayerDTO> searchPlayers(String surname) {
        List<Player> players = playerRepository.findBySurnameContainingIgnoreCase(surname);
        List<PlayerDTO> playersDTO = new ArrayList<>();
        for (Player p : players) {
            playersDTO.add(mapper.playerToPlayerDTO(p));
        }
        return playersDTO;
    }

}
