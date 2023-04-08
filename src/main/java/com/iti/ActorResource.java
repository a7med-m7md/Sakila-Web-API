package com.iti;

import com.iti.persistence.JPAFactoryManager;
import com.iti.persistence.entities.Actor;
import com.iti.services.dtos.ActorDto;
import com.iti.services.ActorService;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


// api/v1
@Path("actors")
public class ActorResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActors(@QueryParam("page") int page, @QueryParam("size") int size){
        EntityManager entityManager = JPAFactoryManager.createEntityManager();
        ActorService actorService = new ActorService(entityManager);
        List<ActorDto> actor = actorService.getAllActors(page, size);
        return Response.ok().entity(actor).build();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActor(@PathParam("id") int id) {
        EntityManager entityManager = JPAFactoryManager.createEntityManager();
        ActorService actorService = new ActorService(entityManager);
        ActorDto actor = actorService.getActor(id).get();
        return Response.ok().entity(actor).build();
    }

    @POST
    public Response createActor(Actor actor){
        EntityManager entityManager = JPAFactoryManager.createEntityManager();
        ActorService actorService = new ActorService(entityManager);
        actorService.create(actor);
        return Response.noContent().build();
    }


}
