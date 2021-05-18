package com.example.models;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String studentName;

    @ManyToOne
    @JoinColumn(name = "groupId", referencedColumnName = "groupId", nullable = false)
    private Group group;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String topic;

    @ManyToOne
    @JoinColumn(name = "supervisorId", referencedColumnName = "supervisorId", nullable = false)
    private Supervisor supervisor;

    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String email;

    @Column(columnDefinition = "VARCHAR(15) NOT NULL")
    private String phone;

    public Student() {
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
