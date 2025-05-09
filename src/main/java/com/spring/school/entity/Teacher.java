package com.spring.school.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String entryCode;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
    private List<Subject> subjects;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEntryCode() {
        return entryCode;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void setEntryCode(String entryCode) {
        this.entryCode = entryCode;
    }
}
