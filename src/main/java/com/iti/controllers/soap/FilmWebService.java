package com.iti.controllers.soap;

import com.iti.controllers.soap.exceptions.SoapException;
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
        if (page == 0 || size == 0) {
            page = 1;
            size = 10;
        }
        try {
            return filmService.findAll(page, size);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public void createFilm(@WebParam(name = "film") FilmRequestDto filmRequestDto) {
        try {
            filmService.createFilm(filmRequestDto);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    @WebResult(name = "film")
    public FilmResponseDto getOneFilm(@WebParam(name = "filmId") int filmId) {
        try {
            return filmService.findById(filmId);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public void deleteFilm(@WebParam(name = "filmId") int filmId) {
        try {
            filmService.deleteById(filmId);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    @WebResult(name = "actor")
    public List<ActorResponseDto> getFilmActors(@WebParam(name = "filmId") int filmId) {
        try {
            return filmService.getFilmActors(filmId);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    @WebResult(name = "actor")
    public ActorResponseDto getFilmSpecificActor(
            @WebParam(name = "filmId") int filmId,
            @WebParam(name = "actorId") int actorId
    ) {
        try {
            return filmService.getFilmSpecificActor(filmId, actorId);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    @WebResult(name = "details")
    public FilmDetailsResponseDto getFilmDetails(@WebParam(name = "filmId") int filmId) {
        try {
            return filmService.getFilmDetails(filmId);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

}