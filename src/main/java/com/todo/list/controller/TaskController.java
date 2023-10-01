package com.todo.list.controller;

import com.todo.list.dao.entity.Task;
import com.todo.list.dto.request.TaskCreation;
import com.todo.list.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/getTasks/{email}")
    public ResponseEntity<List<Task>>getTasksByEmail(@PathVariable String email){
         List<Task>taskList=taskService.getTasksByEmail(email);
         return ResponseEntity.ok(taskList);
    }
    @GetMapping("/getTask/{id}")
    public ResponseEntity<Task>getTaskById(Long id){
        Task task=taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/getArchiveTasks/{email}")
    public ResponseEntity<List<Task>>getArchiveTasks(@PathVariable String email){
        List<Task>taskList=taskService.getArchiveTasks(email);
        return ResponseEntity.ok(taskList);
    }

    @PutMapping("/archiveTask/{id}")
    public void archiveTask(@PathVariable Long id){
        taskService.archiveTask(id);
    }

    @PutMapping("/unarchiveTask/{id}")
    public void unarchiveTask(@PathVariable Long id){
        taskService.unarchiveTask(id);
    }

    @DeleteMapping("/deleteTask/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

    @PostMapping("/addTask/{email}")
    public ResponseEntity<Task> createTask(@PathVariable String email, @RequestBody TaskCreation taskCreation){
     Task task=taskService.createTaskByEmail(email,taskCreation);
     return ResponseEntity.ok(task);
    }
    @PutMapping("/updateTask/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id,@RequestBody TaskCreation taskCreation){
        Task task=taskService.updateTask(id, taskCreation);
        return ResponseEntity.ok(task);
    }
}
