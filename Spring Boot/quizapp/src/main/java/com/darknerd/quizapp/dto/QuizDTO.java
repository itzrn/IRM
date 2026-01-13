package com.darknerd.quizapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizDTO {
    private Long id;
    private String title;
}
