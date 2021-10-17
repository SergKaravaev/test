package com.boots.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "services")
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = " id_jobs")
    private Long id_jobs;

    @Column(name = "id_sto")
    private Long id_sto;

 //   private int date;
    @Column(name = "services_price")
    private float services_price;

    public Services() {
    }

    public Services(Long id, Long id_jobs, Long id_sto, float services_price) {
        this.id = id;
        this.id_jobs = id_jobs;
        this.id_sto = id_sto;
        this.services_price = services_price;
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

    public float getServices_price() {
        return services_price;
    }

    public void setServices_price(float services_price) {
        this.services_price = services_price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Services services = (Services) o;
        return Float.compare(services.services_price, services_price) == 0 &&
                Objects.equals(id, services.id) &&
                Objects.equals(id_jobs, services.id_jobs) &&
                Objects.equals(id_sto, services.id_sto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_jobs, id_sto, services_price);
    }

    @Override
    public String toString() {
        return "Services{" +
                "id=" + id +
                ", id_jobs=" + id_jobs +
                ", id_sto=" + id_sto +
                ", services_price=" + services_price +
                '}';
    }
}
