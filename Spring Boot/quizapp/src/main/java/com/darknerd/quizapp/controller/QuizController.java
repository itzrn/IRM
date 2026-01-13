package com.darknerd.quizapp.controller;

import com.darknerd.quizapp.dto.AnswerWrapperDTO;
import com.darknerd.quizapp.dto.QuestionResponseDTO;
import com.darknerd.quizapp.dto.QuizDTO;
import com.darknerd.quizapp.service.QuizService;
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
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return quizService.createQuiz(category, numQ, title);
    }

    @GetMapping("/get/{quizName}")
    public ResponseEntity<?> getQuizQuestions(@PathVariable String quizName){
        return quizService.getQuizQuestions(quizName);
    }

    @GetMapping("/get-all-quiz")
    public ResponseEntity<List<QuizDTO>> getAllQuiz(){
        return quizService.getAllQuiz();
    }

    @PostMapping("/submit/{quizName}")
    public ResponseEntity<?> submitQuiz(@PathVariable String quizName, @RequestBody List<AnswerWrapperDTO> answers){
        return quizService.calculateResult(quizName, answers);
    }
}
