package com.codestates.soloproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ResponseDto {
    private Long id;
    private String title;
    private Long todo_order;
    private boolean completed;
}
