package com.iti.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "store", schema = "sakila", catalog = "")
public class StoreEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "store_id")
    private Object storeId;
    @Basic
    @Column(name = "manager_staff_id")
    private Object managerStaffId;
    @Basic
    @Column(name = "address_id")
    private Object addressId;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public Object getStoreId() {
        return storeId;
    }

    public void setStoreId(Object storeId) {
        this.storeId = storeId;
    }

    public Object getManagerStaffId() {
        return managerStaffId;
    }

    public void setManagerStaffId(Object managerStaffId) {
        this.managerStaffId = managerStaffId;
    }

    public Object getAddressId() {
        return addressId;
    }

    public void setAddressId(Object addressId) {
        this.addressId = addressId;
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

        StoreEntity that = (StoreEntity) o;

        if (storeId != null ? !storeId.equals(that.storeId) : that.storeId != null) return false;
        if (managerStaffId != null ? !managerStaffId.equals(that.managerStaffId) : that.managerStaffId != null)
            return false;
        if (addressId != null ? !addressId.equals(that.addressId) : that.addressId != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(that.lastUpdate) : that.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = storeId != null ? storeId.hashCode() : 0;
        result = 31 * result + (managerStaffId != null ? managerStaffId.hashCode() : 0);
        result = 31 * result + (addressId != null ? addressId.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }
}
