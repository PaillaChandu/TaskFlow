package com.chandu.taskflow.controller;
import com.chandu.taskflow.dto.TaskRequest;
import com.chandu.taskflow.model.*;
import com.chandu.taskflow.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/tasks")
public class TaskController {
 private final TaskService service;
 public TaskController(TaskService service){this.service=service;}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Task create(@Valid @RequestBody TaskRequest r){return service.create(r);}
 @GetMapping public List<Task> list(@RequestParam(required=false) TaskStatus status,@RequestParam(required=false) String search){return service.list(status,search);}
 @GetMapping("/{id}") public Task get(@PathVariable Long id){return service.get(id);}
 @PutMapping("/{id}") public Task update(@PathVariable Long id,@Valid @RequestBody TaskRequest r){return service.update(id,r);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){service.delete(id);}
}