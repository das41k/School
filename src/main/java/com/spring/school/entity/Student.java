package com.spring.school.entity;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "squad_id")
    private Squad squad;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Squad getSquad() {
        return squad;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSquad(Squad squad) {
        this.squad = squad;
    }
}
