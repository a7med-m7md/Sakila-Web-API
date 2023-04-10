package com.iti.controllers.rest;

import com.iti.mappers.FilmCreationMapper;
import com.iti.models.dtos.FilmDto;
import com.iti.models.request.FilmRequestDto;
import com.iti.models.response.ActorResponseDto;
import com.iti.models.response.FilmDetailsResponseDto;
import com.iti.models.response.FilmResponseDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.persistence.entities.Film;
import com.iti.services.FilmService;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Path("films")
public class FilmResource {
    FilmService filmService;
    EntityManager entityManager;
    public FilmResource() {
        entityManager = JPAFactoryManager.createEntityManager();
        filmService = new FilmService(entityManager);
    }

    @GET
    public Response getAllFilms(@DefaultValue("1") @QueryParam("page") int page,
                                @DefaultValue("10") @QueryParam("size") int size) {
        List<FilmResponseDto> filmResponseDtos = filmService.getAllFilms(page, size);
        return Response.ok().entity(filmResponseDtos).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createFilm(FilmRequestDto filmRequestDto){
        filmService.createFilm(filmRequestDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("{filmId}")
    public Response getOneFilm(@PathParam("filmId") int filmId){
        FilmResponseDto filmResponseDto = filmService.getOneFilm(filmId);
        return Response.ok().entity(filmResponseDto).build();
    }

    @DELETE
    @Path("{filmId}")
    public Response deleteFilm(@PathParam("filmId") int filmId){
        filmService.deleteFilm(filmId);
        return Response.noContent().build();
    }

    @GET
    @Path("{filmId}/actors")
    public Response getFilmActors(@PathParam("filmId") int filmId){
        List<ActorResponseDto> actorResponseDtos = filmService.getFilmActors(filmId);
        System.out.println(actorResponseDtos);
        return Response.ok().entity(actorResponseDtos).build();
    }

    @GET
    @Path("{filmId}/actors/{actorId}")
    public Response getFilmSpecificActor(@PathParam("filmId") int filmId, @PathParam("actorId") int actorId){
        ActorResponseDto actorResponseDto = filmService.getFilmSpecificActor(filmId, actorId);
        return Response.ok().entity(actorResponseDto).build();
    }


    @GET
    @Path("{filmId}/details")
    public Response getFilmDetails(@PathParam("filmId") int filmId){
        FilmDetailsResponseDto filmDetailsResponseDto = filmService.getFilmDetails(filmId);
        return Response.ok().entity(filmDetailsResponseDto).build();
    }

}
