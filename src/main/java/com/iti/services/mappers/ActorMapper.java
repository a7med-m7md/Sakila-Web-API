package com.iti.services.mappers;

import com.iti.persistence.entities.Actor;
import com.iti.services.dtos.ActorDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface ActorMapper {
    Actor toEntity(ActorDto actorDto);

    ActorDto toDto(Actor actor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Actor partialUpdate(ActorDto actorDto, @MappingTarget Actor actor);

    @AfterMapping
    default void linkFilmActors(@MappingTarget Actor actor) {
        actor.getActorFilms().forEach(filmActor -> filmActor.setActor(actor));
    }
}