package com.codestates.soloproject.exception;

import lombok.Getter;

public enum ExceptionCode {
    TODOLIST_NOT_FOUND(404, "ToDo not found");


    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}