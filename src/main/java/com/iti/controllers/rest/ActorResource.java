package com.iti.controllers.rest;

import com.iti.models.response.ActorFilmResponseDto;
import com.iti.models.response.ActorResponseDto;
import com.iti.models.response.FilmDetailsResponseDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.persistence.entities.Actor;
import com.iti.services.ActorService;
import com.iti.services.dtos.FilmActorDto;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Set;


// api/v1
@Path("actors")
public class ActorResource {
    EntityManager entityManager;
    ActorService actorService;
    public ActorResource(){
        entityManager = JPAFactoryManager.createEntityManager();
        actorService = new ActorService(entityManager);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActors(@QueryParam("page") int page, @QueryParam("size") int size){
        List<ActorResponseDto> actor = actorService.getAllActors(page, size);
        return Response.ok().entity(actor).build();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActor(@PathParam("id") int id) {
        ActorResponseDto actor = actorService.getActor(id).get();
        return Response.ok().entity(actor).build();
    }

    @POST
    public Response createActor(Actor actor){
        actorService.create(actor);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response updateActor(@PathParam("id") int id, Actor actor){
        actorService.updateActor(actor, id);
        return Response.noContent().build();
    }

    @GET
    @Path("{id}/films")
    public Response getActorFilms(@PathParam("id") int id){
        List<ActorFilmResponseDto> films = actorService.getActorFilms(id);
        return Response.ok().entity(films).build();
    }

    @POST
    @Path("{actorId}/films")
    public Response createFilmForActor(@PathParam("actorId") int actorId){
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("{actorId}/films/{filmId}")
    public Response getActorOneFilm(@PathParam("actorId") int actorId, @PathParam("filmId") int filmId){
        ActorFilmResponseDto film = actorService.getActorOneFilm(actorId, filmId);
        return Response.ok().entity(film).build();
    }

    @DELETE
    @Path("{actorId}/films/{filmId}")
    public Response deleteActorFilm(@PathParam("actorId") int actorId, @PathParam("filmId") int filmId){
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("{actorId}/films/{filmId}/details")
    public Response getActorFilmDetails(@PathParam("actorId") int actorId, @PathParam("filmId") int filmId){
        FilmDetailsResponseDto filmDetailsResponseDto = actorService.getFilmDetails(actorId, filmId);
        return Response.ok().entity(filmDetailsResponseDto).build();
    }
}
