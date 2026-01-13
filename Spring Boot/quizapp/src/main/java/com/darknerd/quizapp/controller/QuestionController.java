package com.darknerd.quizapp.controller;

import com.darknerd.quizapp.dto.QuestionDTO;
import com.darknerd.quizapp.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/add-new-question")
    public ResponseEntity<String> addNewQuestion(@RequestBody @Valid QuestionDTO questionDTO){
        return questionService.addNewQuestion(questionDTO);
    }

    @GetMapping("/get-all-question")
    public ResponseEntity<List<QuestionDTO>> getAllQuestions(){
        return questionService.getAllQuestion();
    }

    @GetMapping("/get-all-question-by-difficulty/{difficulty}")
    public ResponseEntity<List<QuestionDTO>> getAllQuestionsByDifficulty(@PathVariable String difficulty){
        return questionService.getAllQuestionOfDifficulty(difficulty.toUpperCase());
    }

    @GetMapping("/get-all-question-by-category/{category}")
    public ResponseEntity<List<QuestionDTO>> getAllQuestionsByCategory(@PathVariable String category){
        return questionService.getAllQuestionOfCategory(category.toUpperCase());
    }
}
