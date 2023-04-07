package com.codestates.soloproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter // 지양하자
@Entity
@Table(name = "todos")
@NoArgsConstructor
public class ToDoList {

    @Id // primary key를 id 에너테이션으로 함
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contents")
    private String title;

    @Column
    private Long todo_order;

    @Column
    private boolean completed;
}
