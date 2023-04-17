package com.iti.controllers.soap;

import com.iti.mappers.ActorMapper;
import com.iti.models.request.ActorRequestDto;
import com.iti.models.response.ActorResponseDto;
import com.iti.models.response.FilmDetailsResponseDto;
import com.iti.models.response.FilmResponseDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.persistence.repository.ActorRepository;
import com.iti.services.ActorService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.mapstruct.factory.Mappers;

import java.util.List;

@WebService
public class ActorWebService {
    private final ActorService actorService;

    public ActorWebService() {
        this.actorService = new ActorService(
                new ActorRepository(JPAFactoryManager.createEntityManager()),
                Mappers.getMapper(ActorMapper.class));
    }

    @WebMethod
    public List<ActorResponseDto> getActors(
            @WebParam(name = "page") int page,
            @WebParam(name = "size") int size) {
        if(page == 0 || size == 0){
            page = 1;
            size = 10;
        }
        return actorService.findAll(page, size);
    }

    @WebMethod
    public ActorResponseDto getActor(@WebParam(name = "id") int id) {
        return actorService.findById(id);
    }

    @WebMethod(operationName = "createActor")
    public void createActor(@WebParam(name = "actorRequestDto") ActorRequestDto actorRequestDto) {
        actorService.save(actorRequestDto);
    }

    @WebMethod(operationName = "updateActor")
    public void updateActor(
            @WebParam(name = "id") int id,
            @WebParam(name = "actorRequestDto") ActorRequestDto actorRequestDto) {
        actorService.update(actorRequestDto, id);
    }

    @WebMethod(operationName = "deleteActor")
    public void deleteActor(@WebParam(name = "id") int id) {
        actorService.deleteById(id);
    }

    @WebMethod(operationName = "getActorFilms")
    public List<FilmResponseDto> getActorFilms(@WebParam(name = "id") int id) {
        return actorService.getActorFilms(id);
    }

    @WebMethod(operationName = "createFilmForActor")
    public void createFilmForActor(@WebParam(name = "actorId") int actorId) {
        throw new UnsupportedOperationException();
    }

    @WebMethod(operationName = "getActorOneFilm")
    public FilmResponseDto getActorOneFilm(
            @WebParam(name = "actorId") int actorId,
            @WebParam(name = "filmId") int filmId) {
        return actorService.getActorOneFilm(actorId, filmId);
    }

    @WebMethod(operationName = "deleteActorFilm")
    public void deleteActorFilm(
            @WebParam(name = "actorId") int actorId,
            @WebParam(name = "filmId") int filmId) {
        throw new UnsupportedOperationException();
    }

    @WebMethod(operationName = "getActorFilmDetails")
    public FilmDetailsResponseDto getActorFilmDetails(
            @WebParam(name = "actorId") int actorId,
            @WebParam(name = "filmId") int filmId) {
        return actorService.getFilmDetails(actorId, filmId);
    }
}