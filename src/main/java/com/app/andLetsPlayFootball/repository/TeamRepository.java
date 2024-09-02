package com.app.andLetsPlayFootball.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.andLetsPlayFootball.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    
    List<Team> findByNameContainingIgnoreCase(String name);

}
