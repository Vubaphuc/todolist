package com.example.todolist.model;

import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Todo {
    private Integer id;
    private String title;
    private boolean status;
}
