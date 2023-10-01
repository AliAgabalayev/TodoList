package com.todo.list.dto.request;

import com.todo.list.model.TaskStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskCreation {
    private String taskName;
    private TaskStatus taskStatus;
    private String description;
    private LocalDate taskDeadlineDate;
}