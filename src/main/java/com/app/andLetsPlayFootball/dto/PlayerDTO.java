package com.app.andLetsPlayFootball.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class PlayerDTO {
    
    private Long playerId;
    private String playerName;
    private TeamDTO playerTeamDTO;

}
