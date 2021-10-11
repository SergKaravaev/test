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

    @Column(name = "models")
    private String models;

    @Column(name = "id_users")
    private Long id_users;

    public Avto() {
    }

    public Avto(String brant, String models, Long id_users) {
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
}
