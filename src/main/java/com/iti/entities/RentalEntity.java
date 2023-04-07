package com.iti.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "rental", schema = "sakila", catalog = "")
public class RentalEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "rental_id")
    private int rentalId;
    @Basic
    @Column(name = "rental_date")
    private Timestamp rentalDate;
    @Basic
    @Column(name = "inventory_id")
    private Object inventoryId;
    @Basic
    @Column(name = "customer_id")
    private Object customerId;
    @Basic
    @Column(name = "return_date")
    private Timestamp returnDate;
    @Basic
    @Column(name = "staff_id")
    private Object staffId;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public Timestamp getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Timestamp rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Object getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Object inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Object getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Object customerId) {
        this.customerId = customerId;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    public Object getStaffId() {
        return staffId;
    }

    public void setStaffId(Object staffId) {
        this.staffId = staffId;
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

        RentalEntity that = (RentalEntity) o;

        if (rentalId != that.rentalId) return false;
        if (rentalDate != null ? !rentalDate.equals(that.rentalDate) : that.rentalDate != null) return false;
        if (inventoryId != null ? !inventoryId.equals(that.inventoryId) : that.inventoryId != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (returnDate != null ? !returnDate.equals(that.returnDate) : that.returnDate != null) return false;
        if (staffId != null ? !staffId.equals(that.staffId) : that.staffId != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(that.lastUpdate) : that.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rentalId;
        result = 31 * result + (rentalDate != null ? rentalDate.hashCode() : 0);
        result = 31 * result + (inventoryId != null ? inventoryId.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (returnDate != null ? returnDate.hashCode() : 0);
        result = 31 * result + (staffId != null ? staffId.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }
}
