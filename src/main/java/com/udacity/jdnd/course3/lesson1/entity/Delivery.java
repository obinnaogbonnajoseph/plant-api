package com.udacity.jdnd.course3.lesson1.entity;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NamedQuery(name = "Delivery.findByRecipientName",
        query = "select d from Delivery d where d.recipientName = :name")
@Entity
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "address_full", length = 500)
    private String address;

    @Nationalized
    private String recipientName;

    private LocalDateTime deliveryTime;

    @Type(type = "yes_no")
    private Boolean isCompleted = false;

    @OneToMany(mappedBy = "delivery", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Plant> plants;

    public Delivery(String name, String address, LocalDateTime deliveryTime) {
        this.recipientName = name;
        this.address = address;
        this.deliveryTime = deliveryTime;
    }

    public Delivery() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }
}
