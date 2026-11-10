package com.chandu.taskflow.service;
import com.chandu.taskflow.dto.TaskRequest;
import com.chandu.taskflow.exception.TaskNotFoundException;
import com.chandu.taskflow.model.*;
import com.chandu.taskflow.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service @Transactional
public class TaskService {
 private final TaskRepository repo;
 public TaskService(TaskRepository repo){this.repo=repo;}
 public Task create(TaskRequest r){Task t=new Task();apply(t,r);return repo.save(t);}
 @Transactional(readOnly=true) public List<Task> list(TaskStatus status,String search){
  if(status!=null)return repo.findByStatus(status);
  if(search!=null&&!search.isBlank())return repo.findByTitleContainingIgnoreCase(search.trim());
  return repo.findAll();
 }
 @Transactional(readOnly=true) public Task get(Long id){return repo.findById(id).orElseThrow(()->new TaskNotFoundException(id));}
 public Task update(Long id,TaskRequest r){Task t=get(id);apply(t,r);return repo.save(t);}
 public void delete(Long id){repo.delete(get(id));}
 private void apply(Task t,TaskRequest r){
  t.setTitle(r.title().trim());t.setDescription(r.description());
  t.setStatus(r.status()==null?TaskStatus.TODO:r.status());
  t.setPriority(r.priority()==null?TaskPriority.MEDIUM:r.priority());t.setDueDate(r.dueDate());
 }
}