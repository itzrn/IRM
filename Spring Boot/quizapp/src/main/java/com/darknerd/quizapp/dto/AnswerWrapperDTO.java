package com.darknerd.quizapp.dto;

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
