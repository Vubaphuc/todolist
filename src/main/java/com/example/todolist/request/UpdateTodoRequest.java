package com.example.todolist.request;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateTodoRequest {
    private String title;
//    private String level;
    private boolean status;
}
