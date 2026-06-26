package com.example.schedule.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class PatchScheduleResponse {
    private final Long scheduleId;
    private final String scheduleName;
    private final String contents;
    private final String authorName;
    private final LocalDateTime modifiedAt;

}
