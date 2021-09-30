package spring.models;

import javax.persistence.*;

@Entity
@Table(name="imploer")
public class Imploer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name")
    private String name;

    @Column(name ="surname")
    private String surname;

    @Column(name ="id_jobs")
    private Long id_jobs;

    public Imploer() {
    }

    public Imploer(Long id, String name, String surname, Long id_jobs) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.id_jobs = id_jobs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getId_jobs() {
        return id_jobs;
    }

    public void setId_jobs(Long id_jobs) {
        this.id_jobs = id_jobs;
    }
}
