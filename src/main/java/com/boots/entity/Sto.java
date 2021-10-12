package com.boots.entity;

import javax.persistence.*;

@Entity
@Table(name = "sto")
public class Sto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_avto")
    private Long id_avto;

    public Sto() {
    }

    public Sto(Long id_avto) {
        this.id_avto = id_avto;
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
}
