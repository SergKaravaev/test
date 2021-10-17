package com.boots.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "avto")
public class Avto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "brant")
    private String brant;

    @Column(name = "models")
    private String models;

    @Column(name = "id_users")
    private Long id_users;

    public Avto() {
    }

    public Avto(Long id, String brant, String models, Long id_users) {
        this.id = id;
        this.brant = brant;
        this.models = models;
        this.id_users = id_users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrant() {
        return brant;
    }

    public void setBrant(String brant) {
        this.brant = brant;
    }

    public String getModels() {
        return models;
    }

    public void setModels(String models) {
        this.models = models;
    }

    public Long getId_users() {
        return id_users;
    }

    public void setId_users(Long id_users) {
        this.id_users = id_users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avto avto = (Avto) o;
        return Objects.equals(id, avto.id) &&
                Objects.equals(brant, avto.brant) &&
                Objects.equals(models, avto.models) &&
                Objects.equals(id_users, avto.id_users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brant, models, id_users);
    }

    @Override
    public String toString() {
        return "Avto{" +
                "id=" + id +
                ", brant='" + brant + '\'' +
                ", models='" + models + '\'' +
                ", id_users=" + id_users +
                '}';
    }
}
