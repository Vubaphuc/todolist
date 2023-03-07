package com.example.todolist.service;

import com.example.todolist.database.TodoDB;
import com.example.todolist.exception.NotFoundException;
import com.example.todolist.model.Todo;
import com.example.todolist.reponsitory.TodoReponsitory;
import com.example.todolist.request.CreateTodoRequest;
import com.example.todolist.request.UpdateTodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class TodoService {

    @Autowired
    private TodoReponsitory reponsitory;

    public TodoService() {

    }
    private int generateId() {
        Random rd = new Random();
        return rd.nextInt(1000 - 100 + 1) + 100;
    }

    public List<Todo> getAllTodo() {
        return reponsitory.getAllTodo();
    }
    public Todo getTodoById(Integer id) {
        return reponsitory.getTodoById(id);
    }

    public Todo createTodo (CreateTodoRequest request) {
        Todo todo = Todo.builder()
                .id(generateId())
                .title(request.getTitle())
                .status(false)
                .build();
        TodoDB.todos.add(todo);
        return todo;
    }

    public Todo updateTodo (Integer id , UpdateTodoRequest request) {
        Todo todo = reponsitory.getTodoById(id);
        todo.setTitle(request.getTitle());
        todo.setStatus(request.isStatus());
        return todo;
    }

    public void deteletTodo (Integer id) {
        TodoDB.todos.removeIf(todo -> Objects.equals(todo.getId(),id));
    }
}
