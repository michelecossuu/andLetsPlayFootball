package com.app.andLetsPlayFootball.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "teams")
@Getter @Setter @ToString
public class Team {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;

    @OneToMany(mappedBy = "team")
    private List<Player> players;

}

