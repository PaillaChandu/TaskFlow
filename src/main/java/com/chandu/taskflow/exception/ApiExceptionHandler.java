package com.chandu.taskflow.exception;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.*;
@RestControllerAdvice
public class ApiExceptionHandler {
 @ExceptionHandler(TaskNotFoundException.class) ResponseEntity<Map<String,Object>> missing(TaskNotFoundException e){return body(HttpStatus.NOT_FOUND,e.getMessage());}
 @ExceptionHandler(MethodArgumentNotValidException.class) ResponseEntity<Map<String,Object>> invalid(MethodArgumentNotValidException e){
  String msg=e.getBindingResult().getFieldErrors().stream().findFirst().map(x->x.getField()+": "+x.getDefaultMessage()).orElse("Invalid request");
  return body(HttpStatus.BAD_REQUEST,msg);
 }
 private ResponseEntity<Map<String,Object>> body(HttpStatus s,String m){Map<String,Object>b=new LinkedHashMap<>();b.put("timestamp",LocalDateTime.now());b.put("status",s.value());b.put("message",m);return ResponseEntity.status(s).body(b);}
}