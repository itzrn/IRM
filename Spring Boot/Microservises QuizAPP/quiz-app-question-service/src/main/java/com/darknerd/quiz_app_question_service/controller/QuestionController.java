package com.darknerd.quiz_app_question_service.controller;

import com.darknerd.quiz_app_question_service.dto.AnswerWrapperDTO;
import com.darknerd.quiz_app_question_service.dto.QuestionDTO;
import com.darknerd.quiz_app_question_service.dto.QuestionResponseDTO;
import com.darknerd.quiz_app_question_service.service.QuestionService;
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

    @GetMapping("/generate")
    public ResponseEntity<List<Long>> getQuestionForQuiz(@RequestParam String category, @RequestParam Integer numQ){
        return questionService.getQuestionsForQuiz(category, numQ);
    }

    @PostMapping("/get-questions")
    public ResponseEntity<List<QuestionResponseDTO>> getQuestionFromId(@RequestBody List<Long> questionsIds){
        return questionService.getQuestionFromId(questionsIds);
    }

    @PostMapping("/get-score")
    public ResponseEntity<Integer> getScore(@RequestBody List<AnswerWrapperDTO> answerWrapperDTOS){
        return questionService.getScore(answerWrapperDTOS);
    }
}