package com.todo.list.dao.repository;

import com.todo.list.dao.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
