package com.codestates.soloproject.repository;

import com.codestates.soloproject.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDoList, Long> {

}
