package com.iti.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "country", schema = "sakila", catalog = "")
public class CountryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "country_id")
    private Object countryId;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public Object getCountryId() {
        return countryId;
    }

    public void setCountryId(Object countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

        CountryEntity that = (CountryEntity) o;

        if (countryId != null ? !countryId.equals(that.countryId) : that.countryId != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(that.lastUpdate) : that.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countryId != null ? countryId.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }
}
