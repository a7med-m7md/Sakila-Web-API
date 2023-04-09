package com.iti.services.mappers;

import com.iti.models.response.ActorFilmResponseDto;
import com.iti.persistence.entities.Film;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface ActorFilmMapper {
    Film toEntity(ActorFilmResponseDto actorFilmResponseDto);

    ActorFilmResponseDto toDto(Film film);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Film partialUpdate(ActorFilmResponseDto actorFilmResponseDto, @MappingTarget Film film);
}