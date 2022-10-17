package com.flicklax.todolist.entity;

import lombok.*;

import javax.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "todo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Todo {

    @Id
    @GeneratedValue
    private UUID id;
    private String task;
    private boolean isDone = false;

    public Todo(String task) {
        this.task = task;
    }
}