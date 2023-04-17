package com.iti.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "store")
public class Store {
    @Id
    @Column(name = "store_id", columnDefinition = "TINYINT UNSIGNED not null")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "manager_staff_id", nullable = false)
    private Staff managerStaff;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Column(name = "last_update", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Instant lastUpdate;

    @OneToMany(mappedBy = "store")
    private Set<Inventory> inventories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "store")
    private Set<Staff> staff = new LinkedHashSet<>();

    @OneToMany(mappedBy = "store")
    private Set<Customer> customers = new LinkedHashSet<>();

}