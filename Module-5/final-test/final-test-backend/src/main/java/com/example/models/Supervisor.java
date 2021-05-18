package com.example.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supervisorId;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String supervisorName;

    @OneToMany(mappedBy = "supervisor")
    @JsonIgnore
    private Set<Student> students;

    public Supervisor() {
    }

    public Integer getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Integer supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
