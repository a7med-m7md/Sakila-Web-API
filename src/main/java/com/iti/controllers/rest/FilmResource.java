package com.iti.controllers.rest;

import com.iti.models.response.FilmResponseDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.services.FilmService;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

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

    @GET
    @Path("{filmId}")
    public Response getOneFilm(@PathParam("filmId") int filmId){
        FilmResponseDto filmResponseDto = filmService.getOneFilm(filmId);
        return Response.ok().entity(filmResponseDto).build();
    }



}
