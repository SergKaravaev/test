package com.boots.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users_services")
public class UsersServices {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "id_users")
        private Long id_users;

        @Column(name = "id_services")
        private Long id_services;

        @Column(name = "work_employee")
        private String work_employee;

    public UsersServices() {
    }

    public UsersServices(Long id, Long id_users, Long id_services, String work_employee) {
        this.id = id;
        this.id_users = id_users;
        this.id_services = id_services;
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

    public Long getId_services() {
        return id_services;
    }

    public void setId_services(Long id_services) {
        this.id_services = id_services;
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
        UsersServices that = (UsersServices) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(id_users, that.id_users) &&
                Objects.equals(id_services, that.id_services) &&
                Objects.equals(work_employee, that.work_employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_users, id_services, work_employee);
    }

    @Override
    public String toString() {
        return "UsersServices{" +
                "id=" + id +
                ", id_users=" + id_users +
                ", id_services=" + id_services +
                ", work_employee='" + work_employee + '\'' +
                '}';
    }
}
