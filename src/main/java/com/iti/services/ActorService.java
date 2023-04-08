package com.iti.services;

import com.iti.persistence.entities.Actor;
import com.iti.persistence.repository.BaseRepository;
import com.iti.services.dtos.ActorDto;
import com.iti.services.mappers.ActorMapper;
import jakarta.persistence.EntityManager;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ActorService extends BaseRepository<Actor> {
    ActorMapper actorMapper;
    public ActorService(EntityManager entityManager) {
        super(entityManager);
    }

    public List<ActorDto> getAllActors(){
        List<Actor> actors = findAll();
        actorMapper = Mappers.getMapper(ActorMapper.class);
        List<ActorDto> actorDtos = new ArrayList<>();
        for(Actor actor: actors){
            ActorDto actorDto = actorMapper.toDto(actor);
            actorDtos.add(actorDto);
        }
        return actorDtos;
    }

    public Optional<ActorDto> getActor(int id){
        Optional<Actor> actor = findOne(id);
        if(actor.isPresent()){
               actorMapper = Mappers.getMapper(ActorMapper.class);
               ActorDto actorDto = actorMapper.toDto(actor.get());
               return Optional.of(actorDto);
        }
        return Optional.empty();
    }
}
