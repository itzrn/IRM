package com.darknerd.quiz_app_question_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(
        name = "questions",
        uniqueConstraints = {
                @UniqueConstraint(name="unique_question_title_category", columnNames = {"question_title", "category_id"})
        },
        indexes = {
                @Index(name = "idx_question_category", columnList = "category_id"),
                @Index(name = "idx_question_difficulty", columnList = "difficulty_id")
        }
)
public class Question {

    // ------------- Row ID -------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ---------------- Relation ship ----------------
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "difficulty_id", nullable = false)
    private Difficulty difficulty;

    // --------------------- Columns ------------------
    @Column(name = "question_title", nullable = false)
    private String questionTitle;

    @Column(nullable = false)
    private String option1;

    @Column(nullable = false)
    private String option2;

    @Column(nullable = false)
    private String option3;

    @Column(nullable = false)
    private String option4;

    @Column(name = "right_option", nullable = false)
    private Integer rightOption;
}
