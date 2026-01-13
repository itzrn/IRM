package com.darknerd.quizapp.dto;

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
