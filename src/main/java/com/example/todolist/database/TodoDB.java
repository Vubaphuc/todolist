package com.example.todolist.database;

import com.example.todolist.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoDB {

    public static List<Todo> todos = new ArrayList<>(List.of(
            new Todo(1,"Làm Bài tập",true),
            new Todo(2,"Đá bóng",true),
            new Todo(3,"Đi chơi",false)
    ));
}
