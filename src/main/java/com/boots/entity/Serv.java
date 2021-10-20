package com.boots.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "serv")
public class Serv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = " id_jobs")
    private Long id_jobs;

    @Column(name = "id_sto")
    private Long id_sto;

    @Column(name = "data")
    private Date data;

    @Column(name = "serv_price")
    private float serv_price;

    public Serv() {
    }

    public Serv(Long id_jobs, Long id_sto, Date data, float serv_price) {
        this.id_jobs = id_jobs;
        this.id_sto = id_sto;
        this.data = data;
        this.serv_price = serv_price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_jobs() {
        return id_jobs;
    }

    public void setId_jobs(Long id_jobs) {
        this.id_jobs = id_jobs;
    }

    public Long getId_sto() {
        return id_sto;
    }

    public void setId_sto(Long id_sto) {
        this.id_sto = id_sto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getServ_price() {
        return serv_price;
    }

    public void setServ_price(float serv_price) {
        this.serv_price = serv_price;
    }

}
