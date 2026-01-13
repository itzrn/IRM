package com.darknerd.quiz_app_quiz_service.controller;

import com.darknerd.quiz_app_quiz_service.dto.AnswerWrapperDTO;
import com.darknerd.quiz_app_quiz_service.dto.QuizDTO;
import com.darknerd.quiz_app_quiz_service.service.QuizService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody @Valid QuizDTO quizDTO){
        return quizService.createQuiz(quizDTO);
    }

    @GetMapping("/get/{quizName}")
    public ResponseEntity<?> getQuizQuestions(@PathVariable String quizName){
        return quizService.getQuizQuestions(quizName);
    }

    @PostMapping("/submit/{quizName}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable String quizName, @RequestBody List<AnswerWrapperDTO> answers){
        return quizService.calculateResult(quizName, answers);
    }

}
