package com.iti.services;

import com.iti.models.response.ActorFilmResponseDto;
import com.iti.models.response.ActorResponseDto;
import com.iti.models.response.FilmDetailsResponseDto;
import com.iti.persistence.entities.Actor;
import com.iti.persistence.entities.Film;
import com.iti.persistence.repository.ActorRepository;
import com.iti.services.mappers.ActorFilmMapper;
import com.iti.services.mappers.ActorMapper;
import com.iti.services.mappers.FilmDetailsMapper;
import jakarta.persistence.EntityManager;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ActorService extends ActorRepository<Actor> {
    ActorMapper actorMapper;

    public ActorService(EntityManager entityManager) {
        super(entityManager);
    }

    public List<ActorResponseDto> getAllActors(int page, int size) {
        List<Actor> actors = findAll(page, size);
        actorMapper = Mappers.getMapper(ActorMapper.class);
        List<ActorResponseDto> actorDtos = new ArrayList<>();
        for (Actor actor : actors) {
            ActorResponseDto actorResponseDto = actorMapper.toDto(actor);
            actorDtos.add(actorResponseDto);
        }
        return actorDtos;
    }

    public Optional<ActorResponseDto> getActor(int id) {
        Optional<Actor> actor = findOne(id);
        if (actor.isPresent()) {
            actorMapper = Mappers.getMapper(ActorMapper.class);
            ActorResponseDto actorDto = actorMapper.toDto(actor.get());
            return Optional.of(actorDto);
        }
        return Optional.empty();
    }

    public void updateActor(Actor updatedActor, int id) {
        Optional<Actor> optionalActor = findOne(id);
        if (optionalActor.isPresent()) {
            Actor actor = optionalActor.get();
            if (updatedActor.getFirstName() != null)
                actor.setFirstName(updatedActor.getFirstName());
            if (updatedActor.getLastName() != null)
                actor.setLastName(updatedActor.getLastName());
            update(actor);
        }
    }

    public List<ActorFilmResponseDto> getActorFilms(int id) {
        ActorFilmMapper actorFilmMapper = Mappers.getMapper(ActorFilmMapper.class);
        Optional<Actor> optionalActor = findOne(id);
        if (optionalActor.isPresent()) {
            Actor actor = optionalActor.get();
            return actor.getActorFilms().stream()
                    .map((film) -> film.getFilm()).map(film -> actorFilmMapper.toDto(film))
                    .collect(Collectors.toList());
        }
        throw new IllegalArgumentException();
    }

    public ActorFilmResponseDto getActorOneFilm(int actorId, int filmId) {
        ActorFilmMapper actorFilmMapper = Mappers.getMapper(ActorFilmMapper.class);
        Film film =  findActorFilmByIds(actorId, filmId);
        if(film != null){
            ActorFilmResponseDto actorFilmResponseDto = actorFilmMapper.toDto(film);
            return actorFilmResponseDto;
        }
        return null;
    }

    public FilmDetailsResponseDto getFilmDetails(int actorId, int filmId){
        FilmDetailsMapper filmDetialsMapper = Mappers.getMapper(FilmDetailsMapper.class);
        Film film = findActorFilmByIds(actorId, filmId);
        if(film != null){
            FilmDetailsResponseDto filmDetailsResponseDto = filmDetialsMapper.toDto(film);
            System.out.println("AFFFFFFF================");
            filmDetailsResponseDto.getFilmActors().stream();
//            film.getFilmActors().forEach(e-> System.out.println(e.getActor().getFirstName() + " " + e.getActor().getLastName()));
            return filmDetailsResponseDto;
        }
        return null;
    }

}
