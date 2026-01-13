package com.darknerd.quizapp.repository;

import com.darknerd.quizapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {


    @Query(
            value = "SELECT * FROM questions q WHERE q.category_id=:category ORDER BY RANDOM() LIMIT :numQ",
            nativeQuery = true
    )
    List<Question> findRandomQuestionsByCategory(long category, int numQ);
}