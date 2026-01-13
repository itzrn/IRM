package com.darknerd.quiz_app_question_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class QuestionDTO {

    @NotBlank(message = "CATEGORY SHOULDN'T BE EMPTY!")
    private String category;

    @NotBlank(message = "DIFFICULTY SHOULDN'T BE EMPTY!")
    private String difficulty;

    @NotBlank(message = "QUESTIONTITLE SHOULDN'T BE EMPTY!")
    private String questionTitle;

    @NotBlank(message = "OPTION1 SHOULDN'T BE EMPTY!")
    private String option1;

    @NotBlank(message = "OPTION2 SHOULDN'T BE EMPTY!")
    private String option2;

    @NotBlank(message = "OPTION3 SHOULDN'T BE EMPTY!")
    private String option3;

    @NotBlank(message = "OPTION4 SHOULDN'T BE EMPTY!")
    private String option4;

    @NotNull(message = "RIGHT OPTION SHOULDN'T BE EMPTY!")
    private Integer rightOption;

}