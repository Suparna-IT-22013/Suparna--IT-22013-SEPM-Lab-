package com.example.banglaquiz.model;

import jakarta.persistence.*;

@Entity
public class QuizScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String studentId;
    private int score;


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getStudentId() { return studentId; }

    public void setStudentId(String studentId) { this.studentId = studentId; }

    public int getScore() { return score; }

    public void setScore(int score) { this.score = score; }
}
