package com.iti.controllers.soap;

import com.iti.mappers.FilmMapper;
import com.iti.models.request.FilmRequestDto;
import com.iti.models.response.ActorResponseDto;
import com.iti.models.response.FilmDetailsResponseDto;
import com.iti.models.response.FilmResponseDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.persistence.repository.FilmRepository;
import com.iti.services.FilmService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import org.mapstruct.factory.Mappers;

import java.util.List;

@WebService(name = "FilmService")
public class FilmWebService {

    private final FilmService filmService;

    public FilmWebService() {
        filmService = new FilmService(
                new FilmRepository(JPAFactoryManager.createEntityManager()),
                Mappers.getMapper(FilmMapper.class)
        );
    }

    @WebMethod
    @WebResult(name = "film")
    public List<FilmResponseDto> getAllFilms(
            @WebParam(name = "page") int page,
            @WebParam(name = "size") int size
    ) {
        if(page == 0 || size == 0){
            page = 1;
            size = 10;
        }
        return filmService.findAll(page, size);
    }

    @WebMethod
    public void createFilm(@WebParam(name = "film") FilmRequestDto filmRequestDto) {
        filmService.createFilm(filmRequestDto);
    }

    @WebMethod
    @WebResult(name = "film")
    public FilmResponseDto getOneFilm(@WebParam(name = "filmId") int filmId) {
        return filmService.findById(filmId);
    }

    @WebMethod
    public void deleteFilm(@WebParam(name = "filmId") int filmId) {
        filmService.deleteById(filmId);
    }

    @WebMethod
    @WebResult(name = "actor")
    public List<ActorResponseDto> getFilmActors(@WebParam(name = "filmId") int filmId) {
        return filmService.getFilmActors(filmId);
    }

    @WebMethod
    @WebResult(name = "actor")
    public ActorResponseDto getFilmSpecificActor(
            @WebParam(name = "filmId") int filmId,
            @WebParam(name = "actorId") int actorId
    ) {
        return filmService.getFilmSpecificActor(filmId, actorId);
    }

    @WebMethod
    @WebResult(name = "details")
    public FilmDetailsResponseDto getFilmDetails(@WebParam(name = "filmId") int filmId) {
        return filmService.getFilmDetails(filmId);
    }

}