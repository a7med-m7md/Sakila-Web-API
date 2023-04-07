package com.iti.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class FilmActorEntityPK implements Serializable {
    @Column(name = "actor_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Object actorId;
    @Column(name = "film_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Object filmId;

    public Object getActorId() {
        return actorId;
    }

    public void setActorId(Object actorId) {
        this.actorId = actorId;
    }

    public Object getFilmId() {
        return filmId;
    }

    public void setFilmId(Object filmId) {
        this.filmId = filmId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmActorEntityPK that = (FilmActorEntityPK) o;

        if (actorId != null ? !actorId.equals(that.actorId) : that.actorId != null) return false;
        if (filmId != null ? !filmId.equals(that.filmId) : that.filmId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = actorId != null ? actorId.hashCode() : 0;
        result = 31 * result + (filmId != null ? filmId.hashCode() : 0);
        return result;
    }
}
