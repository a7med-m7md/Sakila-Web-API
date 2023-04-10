package com.iti.mappers;

import com.iti.models.request.FilmRequestDto;
import com.iti.persistence.entities.Film;
import com.iti.persistence.entities.Language;
import com.iti.services.LanguageService;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface FilmCreationMapper {
    Film toEntity(FilmRequestDto filmRequestDto);


    FilmRequestDto toDto(Film film);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Film partialUpdate(FilmRequestDto filmRequestDto, @MappingTarget Film film);
}