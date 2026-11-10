package com.chandu.taskflow.dto;
import com.chandu.taskflow.model.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
public record TaskRequest(@NotBlank @Size(max=120) String title,@Size(max=1000) String description,TaskStatus status,TaskPriority priority,LocalDate dueDate) {}