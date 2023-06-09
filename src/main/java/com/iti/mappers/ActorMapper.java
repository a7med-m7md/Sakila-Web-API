package com.iti.mappers;

import com.iti.models.request.ActorRequestDto;
import com.iti.models.response.ActorResponseDto;
import com.iti.persistence.entities.Actor;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface ActorMapper extends BaseMapper<Actor, ActorRequestDto, ActorResponseDto> {
    Actor toEntity(ActorResponseDto actorResponseDto);

    ActorResponseDto toDto(Actor actor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Actor partialUpdate(ActorResponseDto actorResponseDto, @MappingTarget Actor actor);
}