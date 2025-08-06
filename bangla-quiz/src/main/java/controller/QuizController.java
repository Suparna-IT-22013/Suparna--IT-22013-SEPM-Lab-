package com.example.banglaquiz.controller;

import com.example.banglaquiz.model.QuizScore;
import com.example.banglaquiz.repository.QuizScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuizController {

    @Autowired
    private QuizScoreRepository quizScoreRepository;

    @GetMapping("/quiz")
    public String showQuizForm() {
        return "quiz";
    }

    @PostMapping("/submit")
    public String submitQuiz(
            @RequestParam String studentId,
            @RequestParam String q1,
            @RequestParam String q2,
            Model model) {

        int score = 0;

        if (q1.equals("ঢাকা")) score += 13;
        if (q2.equals("পাইথন")) score += 13;

        QuizScore quizScore = new QuizScore();
        quizScore.setStudentId(studentId);
        quizScore.setScore(score);
        quizScoreRepository.save(quizScore);

        model.addAttribute("score", score);
        return "result";
    }
}
