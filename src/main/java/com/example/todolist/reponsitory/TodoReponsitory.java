package com.example.todolist.reponsitory;


import com.example.todolist.database.TodoDB;
import com.example.todolist.exception.NotFoundException;
import com.example.todolist.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoReponsitory {
    public List<Todo> getAllTodo() {
        return TodoDB.todos;
    }

    public Todo getTodoById(Integer id) {
        for (Todo t: TodoDB.todos) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        throw new NotFoundException("Not Found Todo with id = " + id);
    }
}
