package com.iti.mappers;

import com.iti.models.request.FilmRequestDto;
import com.iti.models.response.FilmResponseDto;
import com.iti.persistence.entities.Film;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface FilmMapper extends BaseMapper<Film, FilmRequestDto, FilmResponseDto> {
    Film toEntity(FilmResponseDto filmResponseDto);

    FilmResponseDto toDto(Film film);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Film partialUpdate(FilmResponseDto filmResponseDto, @MappingTarget Film film);
}