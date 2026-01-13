package com.darknerd.quiz_app_quiz_service.feign;

import com.darknerd.quiz_app_quiz_service.dto.AnswerWrapperDTO;
import com.darknerd.quiz_app_quiz_service.dto.QuestionResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@FeignClient(
        name = "QUIZ-APP-QUESTION-SERVICE",
        path = "/dark-nerd-quiz-app-question-service"
)
public interface QuizInterface {
    @GetMapping("/question/generate")
    ResponseEntity<List<Long>> getQuestionForQuiz(@RequestParam String category, @RequestParam Integer numQ);

    @PostMapping("/question/get-questions")
    ResponseEntity<List<QuestionResponseDTO>> getQuestionFromId(@RequestBody List<Long> questionsIds);

    @PostMapping("/question/get-score")
    ResponseEntity<Integer> getScore(@RequestBody List<AnswerWrapperDTO> answerWrapperDTOS);
}
