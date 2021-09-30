package spring.models;

import javax.persistence.*;

@Entity
@Table(name="sto")
public class Sto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="id_avto")
    private Long id_avto;

    @Column(name ="id_imploer")
    private Long id_imploer;

    public Sto() {
    }

    public Sto(Long id, Long id_avto, Long id_imploer) {
        this.id = id;
        this.id_avto = id_avto;
        this.id_imploer = id_imploer;
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

    public Long getId_imploer() {
        return id_imploer;
    }

    public void setId_imploer(Long id_imploer) {
        this.id_imploer = id_imploer;
    }
}
