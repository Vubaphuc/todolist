package com.example.todolist.exception;

// class xử lý lỗi thông tin không được tìm thấy hoặc không tồn tại
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
