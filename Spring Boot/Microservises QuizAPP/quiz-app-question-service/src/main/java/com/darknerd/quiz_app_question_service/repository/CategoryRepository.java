package com.darknerd.quiz_app_question_service.repository;

import com.darknerd.quiz_app_question_service.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
//    If i am using JPA then i have to give the class name Category
//    @Query("SELECT COUNT(c) > 0 FROM Category c WHERE c.category = :category")
//    boolean existsByCategory(@Param("category") String category);



    // as this is the native query this will pass hibernate and directly apply to the database
    @Query(
            value = "SELECT COUNT(c) > 0 FROM categories c WHERE c.category = :category",
            nativeQuery = true
    )
    boolean existsByCategory(@Param("category") String category);

    @Query("SELECT c FROM Category c WHERE c.category = :category")
    Optional<Category> findByCategory(@Param("category") String category);
}