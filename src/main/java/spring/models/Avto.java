package spring.models;

import javax.persistence.*;

@Entity
@Table(name = "avto")
public class Avto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "brant")
    private String brant;

    @Column(name = "model")
    private String model;

    @Column(name = "id_users")
    private Long id_users;

    public Avto() {
    }

    public Avto(String brant, String model, Long id_users) {
        this.brant = brant;
        this.model = model;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getId_users() {
        return id_users;
    }

    public void setId_users(Long id_users) {
        this.id_users = id_users;
    }
}
