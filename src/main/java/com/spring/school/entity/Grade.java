package com.spring.school.entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "grade")
    private int grade;

    @Column(name = "reason")
    private String reason;

    @Column(name = "data_issue")
    private LocalDate dataIssue;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public void setId(int id) {
        this.id = id;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setDataIssue(LocalDate dataIssue) {
        this.dataIssue = dataIssue;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public int getGrade() {
        return grade;
    }

    public String getReason() {
        return reason;
    }

    public LocalDate getDataIssue() {
        return dataIssue;
    }

    public Student getStudent() {
        return student;
    }
    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
