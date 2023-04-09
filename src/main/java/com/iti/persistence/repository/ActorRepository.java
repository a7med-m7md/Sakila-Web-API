package com.iti.persistence.repository;

import com.iti.persistence.entities.Actor;
import com.iti.persistence.entities.Film;
import com.iti.persistence.entities.FilmActor;
import com.iti.persistence.entities.FilmActorId;
import jakarta.persistence.EntityManager;

public abstract class ActorRepository<T> extends BaseRepository<Actor> {
    protected ActorRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public Film findActorFilmByIds(int actorId, int filmId) {
        FilmActorId filmActorId = new FilmActorId(actorId, filmId);
        System.out.println("After");
        FilmActor film = entityManager.find(FilmActor.class, filmActorId);
        System.out.println("Before");
        if (film != null) {
            return film.getFilm();
        }
        return null;
    }

}
