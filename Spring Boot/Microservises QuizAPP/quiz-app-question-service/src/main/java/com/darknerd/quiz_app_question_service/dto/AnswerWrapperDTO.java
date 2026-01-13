package com.darknerd.quiz_app_question_service.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnswerWrapperDTO {
    private Long id;
    private Integer answer;
}
