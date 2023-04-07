package com.codestates.soloproject.controller;

import com.codestates.soloproject.dto.PostDto;
import com.codestates.soloproject.entity.ToDoList;
import com.codestates.soloproject.mapper.ToDoListMapper;
import com.codestates.soloproject.service.ToDoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/ToDo")
@RestController
@Validated
@Slf4j
@RequiredArgsConstructor
public class Controller {

    private final ToDoListMapper mapper; // 변하지않는값 final
    private final ToDoService toDoService;

    @PostMapping
    public ResponseEntity postToDo(@Valid @RequestBody PostDto requestBody) {

        ToDoList toDoList = mapper.postDtoToToDoList(requestBody);

        toDoService.CreateToDo(toDoList);

        return new ResponseEntity<>(mapper.toDoListToResponse(toDoList),HttpStatus.OK);
    }



}
