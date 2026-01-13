package com.darknerd.quiz_app_question_service.repository;

import com.darknerd.quiz_app_question_service.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(
            value = "SELECT q.id FROM questions q WHERE q.category_id=:category ORDER BY RANDOM() LIMIT :numQ",
            nativeQuery = true
    )
    List<Long> findRandomQuestionsByCategory(Long category, int numQ);

    @Query(
            value = "SELECT q.right_option FROM questions q WHERE q.id=:qId",
            nativeQuery = true
    )
    Integer getRightAnswerForGivenQuestionId(Long qId);
}