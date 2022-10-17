package com.flicklax.todolist.service;

import com.flicklax.todolist.entity.Todo;
import com.flicklax.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    public List<Todo> listTodos() {
        return todoRepository.findAll();
    }

    public Todo createTodo(String task) {
        Todo todo = new Todo(task);
        return todoRepository.save(todo);
    }

    public Todo getTodoById(UUID id) {
        return todoRepository.findById(id).orElse(null);
    }

    public Todo updateTodoById(UUID id, Todo todo) {
        Todo todoToUpdate = todoRepository.findById(id).orElse(null);
        if (todoToUpdate != null) {
            todoToUpdate.setTask(todo.getTask());
            todoToUpdate.setDone(todo.isDone());
            return todoRepository.save(todoToUpdate);
        }
        return null;
    }

    public void deleteTodoById(UUID id) {
        todoRepository.deleteById(id);
    }


}
