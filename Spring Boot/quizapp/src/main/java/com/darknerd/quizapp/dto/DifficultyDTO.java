package com.darknerd.quizapp.dto;

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
