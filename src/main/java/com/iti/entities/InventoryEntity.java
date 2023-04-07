package com.iti.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "inventory", schema = "sakila", catalog = "")
public class InventoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "inventory_id")
    private Object inventoryId;
    @Basic
    @Column(name = "film_id")
    private Object filmId;
    @Basic
    @Column(name = "store_id")
    private Object storeId;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public Object getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Object inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Object getFilmId() {
        return filmId;
    }

    public void setFilmId(Object filmId) {
        this.filmId = filmId;
    }

    public Object getStoreId() {
        return storeId;
    }

    public void setStoreId(Object storeId) {
        this.storeId = storeId;
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

        InventoryEntity that = (InventoryEntity) o;

        if (inventoryId != null ? !inventoryId.equals(that.inventoryId) : that.inventoryId != null) return false;
        if (filmId != null ? !filmId.equals(that.filmId) : that.filmId != null) return false;
        if (storeId != null ? !storeId.equals(that.storeId) : that.storeId != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(that.lastUpdate) : that.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = inventoryId != null ? inventoryId.hashCode() : 0;
        result = 31 * result + (filmId != null ? filmId.hashCode() : 0);
        result = 31 * result + (storeId != null ? storeId.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }
}
