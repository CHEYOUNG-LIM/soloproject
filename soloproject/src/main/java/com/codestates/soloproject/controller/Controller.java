package com.codestates.soloproject.controller;

import com.codestates.soloproject.dto.PatchDto;
import com.codestates.soloproject.dto.PostDto;
import com.codestates.soloproject.dto.ResponseDto;
import com.codestates.soloproject.entity.ToDoList;
import com.codestates.soloproject.mapper.ToDoListMapper;
import com.codestates.soloproject.service.ToDoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

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

    @PatchMapping("/{id}")
    public ResponseEntity patchToDo(@PathVariable("id") @Positive long id,
                                    @Validated @RequestBody PatchDto patchDto) {
        ToDoList toDoList = mapper.patchDtoToToDoList(patchDto);
        toDoList.setId(id);

        ToDoList toDoList1 = toDoService.UpdateToDo(toDoList);

        return new ResponseEntity<>(mapper.toDoListToResponse(toDoList1),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getToDo(@PathVariable("id") @Positive long id) {
        ToDoList toDoList = toDoService.findToDoList(id);

        return new ResponseEntity<>(mapper.toDoListToResponse(toDoList),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getToDos() {
        List<ToDoList> toDoLists = toDoService.findToDoLists();
        List<ResponseDto> response = mapper.toDoListToResponseDto(toDoLists);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteToDo(@PathVariable("id") long id) {
        toDoService.deleteToDo(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping()
    public ResponseEntity deleteToDos() {
        toDoService.deleteToDos();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
