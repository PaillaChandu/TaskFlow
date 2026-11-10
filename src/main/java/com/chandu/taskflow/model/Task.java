package com.chandu.taskflow.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity @Table(name="tasks")
public class Task {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,length=120) private String title;
 @Column(length=1000) private String description;
 @Enumerated(EnumType.STRING) @Column(nullable=false) private TaskStatus status=TaskStatus.TODO;
 @Enumerated(EnumType.STRING) @Column(nullable=false) private TaskPriority priority=TaskPriority.MEDIUM;
 private LocalDate dueDate;
 @Column(nullable=false,updatable=false) private LocalDateTime createdAt;
 @Column(nullable=false) private LocalDateTime updatedAt;
 @PrePersist void created(){createdAt=LocalDateTime.now();updatedAt=createdAt;}
 @PreUpdate void updated(){updatedAt=LocalDateTime.now();}
 public Long getId(){return id;} public String getTitle(){return title;} public void setTitle(String v){title=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public TaskStatus getStatus(){return status;} public void setStatus(TaskStatus v){status=v;}
 public TaskPriority getPriority(){return priority;} public void setPriority(TaskPriority v){priority=v;}
 public LocalDate getDueDate(){return dueDate;} public void setDueDate(LocalDate v){dueDate=v;}
 public LocalDateTime getCreatedAt(){return createdAt;} public LocalDateTime getUpdatedAt(){return updatedAt;}
}