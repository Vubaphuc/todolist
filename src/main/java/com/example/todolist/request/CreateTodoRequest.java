package com.example.todolist.request;


import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTodoRequest {
    @NotEmpty(message = "Title không được để trống")
    private String title;
}
