package com.iti.services;

import com.iti.mappers.*;
import com.iti.models.request.FilmRequestDto;
import com.iti.models.response.ActorResponseDto;
import com.iti.models.response.FilmDetailsResponseDto;
import com.iti.models.response.FilmResponseDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.persistence.entities.*;
import com.iti.persistence.repository.ActorRepository;
import com.iti.persistence.repository.BaseRepository;
import com.iti.persistence.repository.FilmRepository;
import jakarta.persistence.EntityManager;
import org.mapstruct.factory.Mappers;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class FilmService extends BaseService<FilmRequestDto, FilmResponseDto, Film> {
    FilmMapper filmMapper;
    BaseRepository<Film> repository;

    public FilmService(BaseRepository repository, BaseMapper mapper) {
        super(repository, mapper);
        filmMapper = Mappers.getMapper(FilmMapper.class);
        this.repository = repository;
    }

//    public List<FilmResponseDto> getAllFilms(int page, int size) {
//        List<FilmResponseDto> filmResponseDtos = new ArrayList<>();
//        List<Film> films = findAll(page, size);
//        for (Film film : films) {
//            FilmResponseDto filmResponseDto = filmMapper.toDto(film);
//            filmResponseDtos.add(filmResponseDto);
//        }
//        return filmResponseDtos;
//    }

//    public FilmResponseDto getOneFilm(int filmId) {
//        Optional<Film> filmOptional = findOne(filmId);
//        if (filmOptional.isPresent()) {
//            Film film = filmOptional.get();
//            FilmResponseDto filmResponseDto = filmMapper.toDto(film);
//            return filmResponseDto;
//        }
//        return null;
//    }

    public FilmDetailsResponseDto getFilmDetails(int filmId) {
        Optional<Film> optionalFilm = repository.findOne(filmId);
        if (optionalFilm.isPresent()) {
            Film film = optionalFilm.get();
            FilmDetailsMapper filmDetailsMapper = Mappers.getMapper(FilmDetailsMapper.class);
            FilmDetailsResponseDto filmDetailsResponseDto = filmDetailsMapper.toDto(film);
            return filmDetailsResponseDto;
        }
        return null;
    }


    public void createFilm(FilmRequestDto filmRequestDto) {
        FilmCreationMapper filmCreationMapper = Mappers.getMapper(FilmCreationMapper.class);
        Film film = filmCreationMapper.toEntity(filmRequestDto);

//        System.out.println(filmRequestDto);
//        // is it coupling ????
//
//        // Add Actors to a film
//        ActorService actorService = new ActorService(new ActorRepository(JPAFactoryManager.createEntityManager()),
//                Mappers.getMapper(ActorMapper.class));

        ActorRepository actorRepository = new ActorRepository(JPAFactoryManager.createEntityManager());

        Set<FilmActor> actors = filmRequestDto.getActorIds()
                .stream()
                .map(actorId -> {
                    Actor actor = actorRepository.findOne(actorId).get();
                    FilmActor filmActor = new FilmActor();
                    filmActor.setId(new FilmActorId(actorId, film.getId()));
                    filmActor.setFilm(film);
                    filmActor.setActor(actor);
                    return filmActor;
                })
                .collect(Collectors.toSet());

        film.setFilmActors(actors);
        // Add Language and original language
        LanguageService languageService = new LanguageService(JPAFactoryManager.createEntityManager());
        Optional<Language> optionalLanguage = languageService.findOne(filmRequestDto.getLanguageId());
        if (optionalLanguage.isPresent()) {
            Language language = optionalLanguage.get();
            film.setLanguage(language);
        }

//         Setting original language
        Optional<Language> optionalOriginalLanguage = languageService.findOne(filmRequestDto.getOriginalLanguageId());
        if(optionalOriginalLanguage.isPresent()){
            Language language = optionalOriginalLanguage.get();
            film.setOriginalLanguage(language);
        }
        System.out.println(film);
        repository.create(film);
    }

//    public void deleteFilm(int filmId) {
//        Optional<Film> optionalFilm = findOne(filmId);
//        if (optionalFilm.isPresent()) {
//            Film film = optionalFilm.get();
//            deleteById(film);
//        }
//    }


    public List<ActorResponseDto> getFilmActors(int filmId) {
        Optional<Film> optionalFilm = repository.findOne(filmId);
        List<ActorResponseDto> actorResponseDtos = new ArrayList<>();
        if (optionalFilm.isPresent()) {
            Film film = optionalFilm.get();
            Set<FilmActor> filmActors = film.getFilmActors();
            System.out.println(filmActors);
            ActorMapper actorMapper = Mappers.getMapper(ActorMapper.class);
            for (FilmActor filmActor : filmActors) {
                ActorResponseDto actorResponseDto = actorMapper.toDto(filmActor.getActor());
                actorResponseDtos.add(actorResponseDto);
            }
            return actorResponseDtos;
        }
        return null;
    }

    public ActorResponseDto getFilmSpecificActor(int filmId, int actorId) {
        Optional<Film> optionalFilm = repository.findOne(filmId);
        if (optionalFilm.isPresent()) {
            Film film = optionalFilm.get();
            Set<FilmActor> filmActors = film.getFilmActors();
            Optional<Actor> optionalActor = filmActors.stream()
                    .filter(actor -> actor.getActor().getId() == actorId)
                    .map(actor-> actor.getActor())
                    .findFirst();
           if(optionalActor != null){
               ActorMapper actorMapper = Mappers.getMapper(ActorMapper.class);
               return actorMapper.toDto(optionalActor.get());
           }
        }
        return null;
    }

}
