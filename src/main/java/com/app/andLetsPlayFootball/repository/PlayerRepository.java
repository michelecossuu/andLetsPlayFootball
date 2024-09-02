package com.app.andLetsPlayFootball.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.andLetsPlayFootball.model.Player;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    
    List<Player> findByNameContainingIgnoreCase(String name);

}
