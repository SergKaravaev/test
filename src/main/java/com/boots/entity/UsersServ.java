package com.boots.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users_serv")
public class UsersServ {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "id_users")
        private Long id_users;

        @Column(name = "id_serv")
        private Long id_serv;

        @Column(name = "work_employee")
        private String work_employee;

    public UsersServ() {
    }

    public UsersServ(Long id_users, Long id_serv, String work_employee) {
        this.id_users = id_users;
        this.id_serv = id_serv;
        this.work_employee = work_employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_users() {
        return id_users;
    }

    public void setId_users(Long id_users) {
        this.id_users = id_users;
    }

    public Long getId_serv() {
        return id_serv;
    }

    public void setId_serv(Long id_serv) {
        this.id_serv = id_serv;
    }

    public String getWork_employee() {
        return work_employee;
    }

    public void setWork_employee(String work_employee) {
        this.work_employee = work_employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersServ usersServ = (UsersServ) o;
        return Objects.equals(id, usersServ.id) && Objects.equals(id_users, usersServ.id_users) && Objects.equals(id_serv, usersServ.id_serv) && Objects.equals(work_employee, usersServ.work_employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_users, id_serv, work_employee);
    }

    @Override
    public String toString() {
        return "UsersServ{" +
                "id=" + id +
                ", id_users=" + id_users +
                ", id_serv=" + id_serv +
                ", work_employee='" + work_employee + '\'' +
                '}';
    }
}
