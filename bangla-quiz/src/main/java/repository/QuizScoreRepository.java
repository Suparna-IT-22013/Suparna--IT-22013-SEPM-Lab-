package com.example.banglaquiz.repository;

import com.example.banglaquiz.model.QuizScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizScoreRepository extends JpaRepository<QuizScore, Integer> {
}
