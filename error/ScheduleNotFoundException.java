package com.example.schedule.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ScheduleNotFoundException extends RuntimeException {
    public ScheduleNotFoundException() {
        super("없는 일정 ID 입니다.");
    }
}
