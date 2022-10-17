package com.flicklax.todolist.controller;

import com.flicklax.todolist.entity.Todo;
import com.flicklax.todolist.entity.dto.TodoRequest;
import com.flicklax.todolist.entity.dto.TodoResponse;
import com.flicklax.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("")
    public List<Todo> getTodos() {
        return todoService.listTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable UUID id) {
        return ResponseEntity.ok(todoService.getTodoById(id));
    }

    @PostMapping("")
    public ResponseEntity<Todo> createTodo(@RequestBody TodoRequest todo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(todoService.createTodo(todo.getTask()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo, @PathVariable UUID id) {
        return ResponseEntity.ok(todoService.updateTodoById(id, todo));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteTodoById(@PathVariable UUID id) {
        todoService.deleteTodoById(id);
        return ResponseEntity.ok().body(new TodoResponse("DELETED SUCCESSFULLY"));
    }


}
