package com.example.schedule.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class PasswordMismatchException extends  RuntimeException {
    public PasswordMismatchException() {
        super("패스워드가 틀렸습니다.");
    }
}
