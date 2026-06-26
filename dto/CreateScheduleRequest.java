package com.example.schedule.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequest {
    private String scheduleName;
    private String contents;
    private String authorName;
    private String schedulePw;
}
