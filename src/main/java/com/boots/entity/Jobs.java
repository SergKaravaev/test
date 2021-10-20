package com.boots.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "jobs")
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type_of_work")
    private String type_of_work;

    @Column(name = "price")
    private float price;

    public Jobs() {
    }

    public Jobs(String type_of_work, float price) {
        this.type_of_work = type_of_work;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType_of_work() {
        return type_of_work;
    }

    public void setType_of_work(String type_of_work) {
        this.type_of_work = type_of_work;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
