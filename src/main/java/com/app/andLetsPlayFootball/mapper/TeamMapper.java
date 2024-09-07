package com.app.andLetsPlayFootball.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.app.andLetsPlayFootball.dto.TeamDTO;
import com.app.andLetsPlayFootball.model.Team;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    @Mapping(target = "teamId", source = "id")
    @Mapping(target = "teamName", source = "name")
    TeamDTO teamToTeamDTO(Team team);
    
} 