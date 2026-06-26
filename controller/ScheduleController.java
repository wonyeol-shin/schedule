package com.example.schedule.controller;

import com.example.schedule.dto.*;
import com.example.schedule.service.ScheduleService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping("/schedules")
    public ResponseEntity<List<GetScheduleResponse>> getAllSchedule(
            @RequestParam(value = "authorName", required = false) String authorName
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getAllSchedule(authorName));
    }


    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<GetScheduleResponse> getOneSchedule(
            @PathVariable("scheduleId") Long scheduleId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getOneSchedule(scheduleId));
    }

    @PostMapping("/schedules")
    public ResponseEntity<CreateScheduleResponse> createSchedule(
            @RequestBody CreateScheduleRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.createSchedule(request));
    }

    @PatchMapping("/schedules/{scheduleId}")
    public ResponseEntity<PatchScheduleResponse> patchSchedule(
            @PathVariable("scheduleId") Long scheduleId,
            PatchScheduleRequest request
    ) {
      return   ResponseEntity.status(HttpStatus.OK).body(scheduleService.patchSchedule(scheduleId, request));
    }
}
