package com.darknerd.quiz_app_question_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {
    private Long id;

    @NotBlank(message = "CATEGORY SHOULDN'T BE EMPTY!")
    private String category;
}
