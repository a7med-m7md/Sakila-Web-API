package com.iti.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "language", schema = "sakila", catalog = "")
public class LanguageEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "language_id")
    private Object languageId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public Object getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Object languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        LanguageEntity that = (LanguageEntity) o;

        if (languageId != null ? !languageId.equals(that.languageId) : that.languageId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(that.lastUpdate) : that.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = languageId != null ? languageId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }
}
