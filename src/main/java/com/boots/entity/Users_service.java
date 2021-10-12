package com.boots.entity;

import javax.persistence.*;

@Entity
@Table(name = "users_service")
public class Users_service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_users")
    private Long id_users;

    @Column(name = "id_service")
    private Long id_service;

    @Column(name = "work_employee")
    private String work_employee;

    public Users_service() {
    }

    public Users_service(Long id_users, Long id_service, String work_employee) {
        this.id_users = id_users;
        this.id_service = id_service;
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

    public Long getId_service() {
        return id_service;
    }

    public void setId_service(Long id_service) {
        this.id_service = id_service;
    }

    public String getWork_employee() {
        return work_employee;
    }

    public void setWork_employee(String work_employee) {
        this.work_employee = work_employee;
    }
}

