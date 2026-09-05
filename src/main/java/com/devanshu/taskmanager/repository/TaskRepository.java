package com.devanshu.taskmanager.repository;

import com.devanshu.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}