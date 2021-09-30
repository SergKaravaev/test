package spring.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="avto")
public class Avto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="brant")
    private String brant;


    @Column(name ="id_user")
    private Long id_user;

    public Avto() {
    }

    public Avto(Long id, String brant, Long id_user) {
        this.id = id;
        this.brant = brant;
        this.id_user = id_user;
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

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }
}
