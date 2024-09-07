package com.app.andLetsPlayFootball.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.app.andLetsPlayFootball.dto.PlayerDTO;
import com.app.andLetsPlayFootball.model.Player;

@Mapper(componentModel = "spring", uses = {TeamMapper.class})
public interface PlayerMapper {

    @Mapping(target = "playerId", source = "id")
    @Mapping(target = "playerName", source = "name")
    @Mapping(target = "playerSurname", source = "surname")
    @Mapping(target = "playerRole", source = "role")
    @Mapping(target = "playerTeamDTO", source = "team")
    PlayerDTO playerToPlayerDTO(Player player);

}
