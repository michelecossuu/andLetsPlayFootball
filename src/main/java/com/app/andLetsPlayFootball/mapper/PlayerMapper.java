package com.app.andLetsPlayFootball.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.app.andLetsPlayFootball.dto.PlayerDTO;
import com.app.andLetsPlayFootball.dto.TeamDTO;
import com.app.andLetsPlayFootball.model.Player;
import com.app.andLetsPlayFootball.model.Team;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    @Mapping(target = "playerId", source = "id")
    @Mapping(target = "playerName", source = "name")
    @Mapping(target = "playerTeamDTO.teamId", source = "team.id")
    @Mapping(target = "playerTeamDTO.teamName", source = "team.name")
    PlayerDTO playerToPlayerDTO(Player player);

    @Mapping(target = "teamId", source = "id")
    @Mapping(target = "teamName", source = "name")
    TeamDTO teamToTeamDTO(Team team);

}
