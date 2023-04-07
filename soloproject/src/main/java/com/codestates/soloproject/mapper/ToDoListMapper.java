package com.codestates.soloproject.mapper;

import com.codestates.soloproject.dto.PatchDto;
import com.codestates.soloproject.dto.PostDto;
import com.codestates.soloproject.dto.ResponseDto;
import com.codestates.soloproject.entity.ToDoList;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ToDoListMapper {
    default ToDoList postDtoToToDoList(PostDto requestBody){
        if(requestBody==null) {
            return null;
        }

        ToDoList toDoList = new ToDoList();

        toDoList.setTitle(requestBody.getTitle());
        toDoList.setTodo_order(requestBody.getTodo_order());
        toDoList.setCompleted(requestBody.isCompleted());

        return toDoList;
    };

    default ResponseDto toDoListToResponse(ToDoList requestBody) {
        if (requestBody == null) {
            return null;
        }
        Long id = requestBody.getId();
        String title = requestBody.getTitle();
        Long todo_order = requestBody.getTodo_order();
        boolean completed = requestBody.isCompleted();

        ResponseDto responseDto = new ResponseDto();
        responseDto.setId(id);
        responseDto.setTitle(title);
        responseDto.setTodo_order(todo_order);
        responseDto.setCompleted(completed);

        return responseDto;
    }

    ToDoList patchDtoToToDoList(PatchDto patchDto);

    List<ResponseDto> toDoListToResponseDto(List<ToDoList> toDoLists);
}
