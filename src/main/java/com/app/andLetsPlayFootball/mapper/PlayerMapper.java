package com.app.andLetsPlayFootball.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.app.andLetsPlayFootball.dto.PlayerDTO;
import com.app.andLetsPlayFootball.dto.TeamDTO;
import com.app.andLetsPlayFootball.model.Player;
import com.app.andLetsPlayFootball.model.Team;

@Mapper(componentModel = "spring", uses = {TeamMapper.class})
public interface PlayerMapper {

    @Mapping(target = "playerId", source = "id")
    @Mapping(target = "playerName", source = "name")
    @Mapping(target = "playerTeamDTO.teamId", source = "team.id")
    @Mapping(target = "playerTeamDTO", source = "team")
    PlayerDTO playerToPlayerDTO(Player player);

    @Mapping(target = "teamId", source = "id")
    @Mapping(target = "teamName", source = "name")
    TeamDTO teamToTeamDTO(Team team);

}
