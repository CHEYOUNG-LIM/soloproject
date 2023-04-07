package com.codestates.soloproject.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PatchDto {

    @NotBlank
    private String title;

    @NotNull
    private Long todo_order;

    @NotNull
    private boolean completed;


}
