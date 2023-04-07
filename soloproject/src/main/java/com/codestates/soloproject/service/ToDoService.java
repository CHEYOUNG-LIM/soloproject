package com.codestates.soloproject.service;

import com.codestates.soloproject.entity.ToDoList;
import com.codestates.soloproject.exception.BusinessLogicException;
import com.codestates.soloproject.exception.ExceptionCode;
import com.codestates.soloproject.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor // 필수생성자만 생성시켜줌
@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoList CreateToDo(ToDoList toDoList) { // 반환타입이 ToDoList인 toDoList인자로 CreateToDo 매서드 생성

        return toDoRepository.save(toDoList); // 'CreateToDo에 toDoList 저장하는 매서드이다' 라는 로직
    }

    public ToDoList UpdateToDo(ToDoList toDoList) {


        ToDoList find = findVerifiedToDo(toDoList.getId());

        Optional.ofNullable(toDoList.getTitle())
                .ifPresent(find::setTitle);
        Optional.ofNullable(toDoList.getTodo_order())
                .ifPresent(find::setTodo_order);
        Optional.ofNullable(toDoList.isCompleted())
                .ifPresent(find::setCompleted);

        ToDoList UpdateToDo= toDoRepository.save(toDoList);


        return UpdateToDo;

    }

    public void deleteToDo(long id) {
        ToDoList findToDo = findVerifiedToDo(id);

        toDoRepository.delete(findToDo);
    }

    public ToDoList findToDoList(long id) {
        // 검증이 됐으면?
        return findVerifiedToDo(id);

    }

    public List<ToDoList> findToDoLists() {
        return (List<ToDoList>) toDoRepository.findAll();
    }

    private ToDoList findVerifiedToDo(long id) { // 아이디 검증
        Optional<ToDoList> optionalToDoList = toDoRepository.findById(id);

        ToDoList findToDoList = optionalToDoList.orElseThrow(() -> new BusinessLogicException(ExceptionCode.TODOLIST_NOT_FOUND));
        return findToDoList;
    }

}
