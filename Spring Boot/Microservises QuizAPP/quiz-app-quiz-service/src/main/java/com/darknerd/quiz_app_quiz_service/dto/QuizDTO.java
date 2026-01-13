package com.darknerd.quiz_app_quiz_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizDTO {
    @NotNull
    private String category;
    @NotNull
    private String title;
    @NotNull
    @Min(value = 1)
    private Integer numQ;
}
