package com.flicklax.todolist.entity.dto;

import lombok.Data;

@Data
public class TodoResponse {
    
    private String message;
    public TodoResponse(String message) {
        this.message = message;
    }
}
