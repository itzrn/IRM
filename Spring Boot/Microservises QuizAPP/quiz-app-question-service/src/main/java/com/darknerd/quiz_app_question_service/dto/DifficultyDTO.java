package com.darknerd.quiz_app_question_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DifficultyDTO {
    private Long id;

    @NotBlank(message = "DIFFICULTY SHOULDN'T BE EMPTY!")
    private String difficulty;
}
