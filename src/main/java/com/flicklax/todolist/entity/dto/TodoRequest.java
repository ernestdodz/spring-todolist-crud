package com.flicklax.todolist.entity.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TodoRequest {

    @NotBlank(message = "should not be null")
    private String task;
}
