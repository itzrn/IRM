package com.darknerd.quiz_app_quiz_service.repository;

import com.darknerd.quiz_app_quiz_service.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    @Query("SELECT q FROM Quiz q WHERE q.title=:title")
    Optional<Quiz> findByTitle(String title);
}
