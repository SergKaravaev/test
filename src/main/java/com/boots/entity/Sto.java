package com.boots.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sto")
public class Sto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_avto")
    private Long id_avto;

    @Column(name = "status")
    private String status;

    public Sto() {
    }

    public Sto (Long id_avto, String status) {
        this.id_avto = id_avto;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_avto() {
        return id_avto;
    }

    public void setId_avto(Long id_avto) {
        this.id_avto = id_avto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
