package com.iti.services;

import com.iti.mappers.FilmMapper;
import com.iti.models.response.FilmResponseDto;
import com.iti.persistence.entities.Film;
import com.iti.persistence.repository.FilmRepository;
import jakarta.persistence.EntityManager;
import org.mapstruct.factory.Mappers;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FilmService extends FilmRepository<Film> {
    FilmMapper filmMapper;
    public FilmService(EntityManager entityManager) {
        super(entityManager);
        filmMapper = Mappers.getMapper(FilmMapper.class);
    }

    public List<FilmResponseDto> getAllFilms(int page, int size){
        List<FilmResponseDto> filmResponseDtos = new ArrayList<>();
        List<Film> films = findAll(page, size);
        for(Film film: films){
            FilmResponseDto filmResponseDto = filmMapper.toDto(film);
            filmResponseDtos.add(filmResponseDto);
        }
        return filmResponseDtos;
    }

    public FilmResponseDto getOneFilm(int filmId) {
        Optional<Film> filmOptional = findOne(filmId);
        if(filmOptional.isPresent()){
            Film film = filmOptional.get();
            FilmResponseDto filmResponseDto = filmMapper.toDto(film);
            return filmResponseDto;
        }
        return null;
    }
}
