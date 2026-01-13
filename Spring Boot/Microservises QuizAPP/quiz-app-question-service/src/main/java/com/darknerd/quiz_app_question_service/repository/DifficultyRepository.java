package com.darknerd.quiz_app_question_service.repository;


import com.darknerd.quiz_app_question_service.entity.Difficulty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface DifficultyRepository extends JpaRepository<Difficulty, Long> {
    @Query("SELECT COUNT(d) > 0 FROM Difficulty d WHERE d.difficulty = :difficulty")
    boolean existsByDifficulty(@Param("difficulty") String difficulty);

    @Query("SELECT d FROM Difficulty d WHERE d.difficulty = :difficulty")
    Optional<Difficulty> findByDifficulty(@Param("difficulty") String difficulty);

}