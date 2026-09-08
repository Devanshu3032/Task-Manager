package com.devanshu.taskmanager.repository;

import com.devanshu.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.domain.Sort;
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(String status, Sort sort);
}