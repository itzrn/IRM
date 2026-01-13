package com.darknerd.quizapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionResponseDTO {

    private Long id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
