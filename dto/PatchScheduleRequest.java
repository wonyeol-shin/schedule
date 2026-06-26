package com.example.schedule.dto;

import lombok.Getter;

@Getter
public class PatchScheduleRequest {
    private String scheduleName;
    private String authorName;
    private String schedulePw;
}
