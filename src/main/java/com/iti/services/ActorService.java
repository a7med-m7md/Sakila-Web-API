package com.iti.services;

import com.iti.mappers.BaseMapper;
import com.iti.mappers.FilmMapper;
import com.iti.models.request.ActorRequestDto;
import com.iti.models.response.FilmResponseDto;
import com.iti.models.response.ActorResponseDto;
import com.iti.models.response.FilmDetailsResponseDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.persistence.entities.Actor;
import com.iti.persistence.entities.Film;
import com.iti.persistence.repository.ActorRepository;
import com.iti.mappers.ActorMapper;
import com.iti.mappers.FilmDetailsMapper;
import com.iti.persistence.repository.BaseRepository;
import jakarta.persistence.EntityManager;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ActorService extends BaseService<ActorRequestDto, ActorResponseDto, Actor> {
//    public class ActorService extends ActorRepository<Actor> {
    BaseRepository<Actor> repository;

    public ActorService(BaseRepository<Actor> repository, BaseMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
    }

//    public List<ActorResponseDto> getAllActors(int page, int size) {
//        List<ActorResponseDto> actors = findAll(page, size);
//        actorMapper = Mappers.getMapper(ActorMapper.class);
//        List<ActorResponseDto> actorDtos = new ArrayList<>();
//        for (Actor actor : actors) {
//            ActorResponseDto actorResponseDto = actorMapper.toDto(actor);
//            actorDtos.add(actorResponseDto);
//        }
//        return actorDtos;
//    }

//    public Optional<ActorResponseDto> getActor(int id) {
//        Optional<Actor> actor = findOne(id);
//        if (actor.isPresent()) {
//            actorMapper = Mappers.getMapper(ActorMapper.class);
//            ActorResponseDto actorDto = actorMapper.toDto(actor.get());
//            return Optional.of(actorDto);
//        }
//        return Optional.empty();
//    }

//    public void updateActor(Actor updatedActor, int id) {
//        Optional<Actor> optionalActor = findOne(id);
//        if (optionalActor.isPresent()) {
//            Actor actor = optionalActor.get();
//            if (updatedActor.getFirstName() != null)
//                actor.setFirstName(updatedActor.getFirstName());
//            if (updatedActor.getLastName() != null)
//                actor.setLastName(updatedActor.getLastName());
//            update(actor);
//        }
//    }

    public List<FilmResponseDto> getActorFilms(int id) {
        FilmMapper filmMapper = Mappers.getMapper(FilmMapper.class);
        Optional<Actor> optionalActor = repository.findOne(id);
        if (optionalActor.isPresent()) {
            Actor actor = optionalActor.get();
            return actor.getActorFilms().stream()
                    .map((film) -> film.getFilm()).map(film -> filmMapper.toDto(film))
                    .collect(Collectors.toList());
        }
        throw new IllegalArgumentException();
    }

    public FilmResponseDto getActorOneFilm(int actorId, int filmId) {
        ActorRepository actorRepository = new ActorRepository(JPAFactoryManager.createEntityManager());
        FilmMapper filmMapper = Mappers.getMapper(FilmMapper.class);
        Film film =  actorRepository.findActorFilmByIds(actorId, filmId);
        if(film != null){
            FilmResponseDto filmResponseDto = filmMapper.toDto(film);
            return filmResponseDto;
        }
        return null;
    }

    public FilmDetailsResponseDto getFilmDetails(int actorId, int filmId){
        ActorRepository actorRepository = new ActorRepository(JPAFactoryManager.createEntityManager());
        FilmDetailsMapper filmDetialsMapper = Mappers.getMapper(FilmDetailsMapper.class);
        Film film = actorRepository.findActorFilmByIds(actorId, filmId);
        if(film != null){
            FilmDetailsResponseDto filmDetailsResponseDto = filmDetialsMapper.toDto(film);
            film.getFilmActors().forEach(e-> System.out.println(e.getActor().getFirstName() + " " + e.getActor().getLastName()));
            return filmDetailsResponseDto;
        }
        return null;
    }

}
