package com.darknerd.quiz_app_question_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "difficulties"
)
public class Difficulty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "difficulty_id")
    private Long id;

    @Column(name = "difficulty", unique = true)
    private String difficulty;

    @OneToMany(
            mappedBy = "difficulty",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Question> questions = new ArrayList<>(); // this list is just to make hibernate know there is ont to many relation ship

}
