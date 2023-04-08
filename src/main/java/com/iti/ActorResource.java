package com.iti;

import com.iti.persistence.JPAFactoryManager;
import com.iti.services.dtos.ActorDto;
import com.iti.services.mappers.ActorMapper;
import com.iti.services.ActorService;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


// api/v1
@Path("actors")
public class ActorResource {


    ActorMapper actorMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActors() {
        EntityManager entityManager = JPAFactoryManager.createEntityManager();
        ActorService actor = new ActorService(entityManager);

        ActorDto actor1 = actor.getActor(1).get();

//        actorMapper = Mappers.getMapper(ActorMapper.class);
//        ActorDto d = new ActorMapperImpl().toDto();
//        ActorDto d = actorMapper.toDto(actor1);

//        ActorMapper
        //        ActorDto actor1 = actor.findAll().map
//
//        ActorDto actorDto = actor1.
//
//
//        return Response.ok().entity(actor1.getFirstName()).build();
        return Response.ok().entity(actor1).build();
    }
}
