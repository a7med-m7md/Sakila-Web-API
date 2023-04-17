package com.iti.controllers.rest;

import com.iti.mappers.ActorMapper;
import com.iti.models.request.ActorRequestDto;
import com.iti.models.response.FilmResponseDto;
import com.iti.models.response.ActorResponseDto;
import com.iti.models.response.FilmDetailsResponseDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.persistence.repository.ActorRepository;
import com.iti.services.ActorService;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.mapstruct.factory.Mappers;

import java.util.List;


// api/v1
@Path("actors")
public class ActorResource {
    EntityManager entityManager;
    ActorService actorService;
    public ActorResource(){
        entityManager = JPAFactoryManager.createEntityManager();
        actorService = new ActorService(new ActorRepository(entityManager),
                Mappers.getMapper(ActorMapper.class));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActors(@DefaultValue("1") @QueryParam("page") int page,
                              @DefaultValue("10") @QueryParam("size") int size){
        List<ActorResponseDto> actor = actorService.findAll(page, size);
        return Response.ok().entity(actor).build();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActor(@PathParam("id") int id) {
        ActorResponseDto actor = actorService.findById(id);
        return Response.ok().entity(actor).build();
    }

    @POST
    public Response createActor(ActorRequestDto actorRequestDto){
        actorService.save(actorRequestDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response updateActor(@PathParam("id") int id, ActorRequestDto actorRequestDto){
        actorService.update(actorRequestDto, id);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteActor(@PathParam("id") int id){
        actorService.deleteById(id);
        return Response.noContent().build();
    }

    @GET
    @Path("{id}/films")
    public Response getActorFilms(@PathParam("id") int id){
        List<FilmResponseDto> films = actorService.getActorFilms(id);
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
        FilmResponseDto film = actorService.getActorOneFilm(actorId, filmId);
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
