package com.chandu.taskflow.repository;
import com.chandu.taskflow.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface TaskRepository extends JpaRepository<Task,Long> {
 List<Task> findByStatus(TaskStatus status);
 List<Task> findByTitleContainingIgnoreCase(String title);
}