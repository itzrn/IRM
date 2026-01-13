package com.darknerd.quiz_app_quiz_service.service;

import com.darknerd.quiz_app_quiz_service.dto.AnswerWrapperDTO;
import com.darknerd.quiz_app_quiz_service.dto.QuestionResponseDTO;
import com.darknerd.quiz_app_quiz_service.dto.QuizDTO;
import com.darknerd.quiz_app_quiz_service.entity.Quiz;
import com.darknerd.quiz_app_quiz_service.feign.QuizInterface;
import com.darknerd.quiz_app_quiz_service.repository.QuizRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(QuizDTO quizDTO) {
        List<Long> questionsIds =quizInterface.getQuestionForQuiz(quizDTO.getCategory(), quizDTO.getNumQ()).getBody();
        Quiz quiz = Quiz.builder()
                .title(quizDTO.getTitle())
                .questions(questionsIds)
                .build();
        quizRepository.save(quiz);

        return new ResponseEntity<>(quiz.getTitle() + " QUIZ SUCCESSFULLY CREATED", HttpStatus.OK);
    }

    public ResponseEntity<?> getQuizQuestions(String quizName) {

        Optional<Quiz> optionalQuiz  = quizRepository.findByTitle(quizName);
        if(optionalQuiz.isEmpty()) return new ResponseEntity<>("NO QUIZ FOUND WITH QUIZ NAME "+quizName, HttpStatus.NO_CONTENT);

        List<QuestionResponseDTO> questionResponseDTOS = quizInterface.getQuestionFromId(optionalQuiz.get().getQuestions()).getBody();
        return new ResponseEntity<>(questionResponseDTOS, HttpStatus.OK);
    }


    public ResponseEntity<Integer> calculateResult(String quizName, List<AnswerWrapperDTO> answers) {
        return quizInterface.getScore(answers);
    }
}