package com.iti.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "payment", schema = "sakila", catalog = "")
public class PaymentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "payment_id")
    private Object paymentId;
    @Basic
    @Column(name = "customer_id")
    private Object customerId;
    @Basic
    @Column(name = "staff_id")
    private Object staffId;
    @Basic
    @Column(name = "rental_id")
    private Integer rentalId;
    @Basic
    @Column(name = "amount")
    private BigDecimal amount;
    @Basic
    @Column(name = "payment_date")
    private Timestamp paymentDate;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public Object getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Object paymentId) {
        this.paymentId = paymentId;
    }

    public Object getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Object customerId) {
        this.customerId = customerId;
    }

    public Object getStaffId() {
        return staffId;
    }

    public void setStaffId(Object staffId) {
        this.staffId = staffId;
    }

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
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

        PaymentEntity that = (PaymentEntity) o;

        if (paymentId != null ? !paymentId.equals(that.paymentId) : that.paymentId != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (staffId != null ? !staffId.equals(that.staffId) : that.staffId != null) return false;
        if (rentalId != null ? !rentalId.equals(that.rentalId) : that.rentalId != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (paymentDate != null ? !paymentDate.equals(that.paymentDate) : that.paymentDate != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(that.lastUpdate) : that.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paymentId != null ? paymentId.hashCode() : 0;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (staffId != null ? staffId.hashCode() : 0);
        result = 31 * result + (rentalId != null ? rentalId.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (paymentDate != null ? paymentDate.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }
}
