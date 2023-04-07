package com.iti.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "city", schema = "sakila", catalog = "")
public class CityEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "city_id")
    private Object cityId;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "country_id")
    private Object countryId;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public Object getCityId() {
        return cityId;
    }

    public void setCityId(Object cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Object getCountryId() {
        return countryId;
    }

    public void setCountryId(Object countryId) {
        this.countryId = countryId;
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

        CityEntity that = (CityEntity) o;

        if (cityId != null ? !cityId.equals(that.cityId) : that.cityId != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (countryId != null ? !countryId.equals(that.countryId) : that.countryId != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(that.lastUpdate) : that.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cityId != null ? cityId.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (countryId != null ? countryId.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }
}
