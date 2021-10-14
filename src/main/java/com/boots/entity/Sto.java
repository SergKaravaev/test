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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sto sto = (Sto) o;
        return Objects.equals(id, sto.id) &&
                Objects.equals(id_avto, sto.id_avto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_avto);
    }

    @Override
    public String toString() {
        return "Sto{" +
                "id=" + id +
                ", id_avto=" + id_avto +
                '}';
    }
}
