package com.codestates.soloproject.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class PostDto {
    @NotBlank
    private String title;

    @NotNull
    private Long todo_order;

    @NotNull
    private boolean completed;
}
