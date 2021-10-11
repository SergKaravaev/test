package spring.models;

import javax.persistence.*;

@Entity
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = " id_jobs")
    private Long id_jobs;

    @Column(name = "id_sto")
    private Long id_sto;

 //   private int date;

    private float service_price;

    public Service() {
    }

    public Service(Long id_jobs, Long id_sto, float service_price) {
        this.id_jobs = id_jobs;
        this.id_sto = id_sto;
        this.service_price = service_price;
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

    public float getService_price()
    {
        return service_price;
    }

    public void setService_price(float service_price) {
        this.service_price = service_price;
    }
}
