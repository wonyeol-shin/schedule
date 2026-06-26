package com.example.schedule.service;

import com.example.schedule.dto.GetScheduleResponse;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Transactional(readOnly = true)
    public List<GetScheduleResponse> getAllSchedule() {
        List<Schedule> scheduleList = scheduleRepository.findAll(Sort.by(
                Sort.Order.asc("modifiedAt"),
                Sort.Order.asc("scheduleId")
        ));

      return scheduleList.stream()
                .map(
                        (Schedule) -> new GetScheduleResponse(
                                Schedule.getScheduleId(),
                                Schedule.getScheduleName(),
                                Schedule.getContents(),
                                Schedule.getAuthorName(),
                                Schedule.getCreatedAt(),
                                Schedule.getModifiedAt()
                        )
                )
                .toList();
    }

    @Transactional(readOnly = true)
    public GetScheduleResponse getOneSchedule(Long scheduleId) {
        Schedule getSchedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("없는 일정 ID 입니다.")
        );

        return new GetScheduleResponse(
                getSchedule.getScheduleId(),
                getSchedule.getScheduleName(),
                getSchedule.getContents(),
                getSchedule.getAuthorName(),
                getSchedule.getCreatedAt(),
                getSchedule.getModifiedAt()
        );
    }
}
