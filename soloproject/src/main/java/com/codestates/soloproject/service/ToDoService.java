package com.codestates.soloproject.service;

import com.codestates.soloproject.entity.ToDoList;
import com.codestates.soloproject.exception.BusinessLogicException;
import com.codestates.soloproject.exception.ExceptionCode;
import com.codestates.soloproject.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor // 필수생성자만 생성시켜줌
@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoList CreateToDo(ToDoList toDoList) { // 반환타입이 ToDoList인 toDoList인자로 CreateToDo 매서드 생성

        return toDoRepository.save(toDoList); // 'CreateToDo에 toDoList 저장하는 매서드이다' 라는 로직
    }

    private ToDoList UpdateToDo(ToDoList toDoList) {

        ToDoList UpdateToDo= toDoRepository.save(toDoList);

        return UpdateToDo;

    }

    private void deleteToDo(long id) {
        ToDoList findToDo = findVerifiedToDo(id);

        toDoRepository.delete(findToDo);
    }

    private ToDoList findToDo(long id) {
        // 검증이 됐으면?
        return findVerifiedToDo(id);

    }

    private ToDoList findVerifiedToDo(long id) { // 아이디 검증
        Optional<ToDoList> optionalToDoList = toDoRepository.findById(id);

        ToDoList findToDo = optionalToDoList.orElseThrow(() -> new BusinessLogicException(ExceptionCode.TODOLIST_NOT_FOUND));
        return findToDo;
    }

}
