package com.iti.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "film_actor", schema = "sakila", catalog = "")
@IdClass(FilmActorEntityPK.class)
public class FilmActorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "actor_id")
    private Object actorId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "film_id")
    private Object filmId;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

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

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmActorEntity that = (FilmActorEntity) o;

        if (actorId != null ? !actorId.equals(that.actorId) : that.actorId != null) return false;
        if (filmId != null ? !filmId.equals(that.filmId) : that.filmId != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(that.lastUpdate) : that.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = actorId != null ? actorId.hashCode() : 0;
        result = 31 * result + (filmId != null ? filmId.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }
}
