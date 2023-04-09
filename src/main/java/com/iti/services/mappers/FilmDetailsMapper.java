package com.iti.services.mappers;

import com.iti.models.response.FilmDetailsResponseDto;
import com.iti.persistence.entities.Film;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface FilmDetailsMapper {
    Film toEntity(FilmDetailsResponseDto filmDetailsResponseDto);

    FilmDetailsResponseDto toDto(Film film);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Film partialUpdate(FilmDetailsResponseDto filmDetailsResponseDto, @MappingTarget Film film);
}