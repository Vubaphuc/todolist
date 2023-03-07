package com.example.todolist.controller;


import com.example.todolist.model.Todo;
import com.example.todolist.request.CreateTodoRequest;
import com.example.todolist.request.UpdateTodoRequest;
import com.example.todolist.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class TodoListContronller {

    private final TodoService todoService;



    public TodoListContronller(TodoService todoService) {
        this.todoService = todoService;
    }


    // lấy all todolist
    @GetMapping("todos") // trả về 200
    public List<Todo> getAllTodoList() {
        return todoService.getAllTodo();
    }


    // lấy todo theo id
    @GetMapping("todos/{id}") // trả về 200
    public ResponseEntity<?> getTodoById(@PathVariable Integer id) {
            Todo todo = todoService.getTodoById(id);
            return ResponseEntity.ok(todo);
    }
    // tạo mới todo
    @PostMapping("todos") // trả về 200
    @ResponseStatus(HttpStatus.CREATED) // trả về 201
    public Todo createTodo(@Valid @RequestBody CreateTodoRequest request) {

        return todoService.createTodo(request);
    }

    // sửa todo
    @PutMapping("todos/{id}") // trả về 200
    public Todo putTodo(@PathVariable Integer id, @RequestBody UpdateTodoRequest request) {

        return todoService.updateTodo(id,request);
    }

    // xoa todo
    @DeleteMapping("todos/{id}") // trả về 200
    @ResponseStatus(HttpStatus.NO_CONTENT) // trả về 204
    public void deteletTodo(@PathVariable Integer id) {
        todoService.deteletTodo(id);
    }

}
