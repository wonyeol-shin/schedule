package com.example.schedule.service;

import com.example.schedule.dto.*;
import com.example.schedule.entity.Schedule;
import com.example.schedule.error.PasswordMismatchException;
import com.example.schedule.error.ScheduleNotFoundException;
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
    public List<GetScheduleResponse> getAllSchedule(String authorName) {

        List<Schedule> scheduleList;
        if (authorName == null) {
            scheduleList  = scheduleRepository.findAll(Sort.by(
                    Sort.Order.asc("modifiedAt"),
                    Sort.Order.asc("scheduleId")
            ));
        }
        else {
            scheduleList = scheduleRepository.findByAuthorName(
                    authorName,
                    Sort.by(
                            Sort.Order.asc("modifiedAt"),
                            Sort.Order.asc("scheduleId")
                    ));
        }

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
                () -> new ScheduleNotFoundException()
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

    @Transactional
    public CreateScheduleResponse createSchedule(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(
                request.getScheduleName(),
                request.getContents(),
                request.getAuthorName(),
                request.getSchedulePw()
        );

        Schedule newSchedule =  scheduleRepository.save(schedule);

        return new CreateScheduleResponse(
                newSchedule.getScheduleId(),
                newSchedule.getScheduleName(),
                newSchedule.getContents(),
                newSchedule.getAuthorName(),
                newSchedule.getCreatedAt(),
                newSchedule.getModifiedAt()
        );
    }

    @Transactional
    public PatchScheduleResponse patchSchedule(Long scheduleId, PatchScheduleRequest request) {
        Schedule getSchedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new ScheduleNotFoundException());
        // 패스워드가 다를 경우

        if (!request.getSchedulePw().equals(getSchedule.getSchedulePw())) {
            throw new PasswordMismatchException();
        }

        getSchedule.updateSchedule(request.getScheduleName(), request.getAuthorName());

        return new PatchScheduleResponse(
                getSchedule.getScheduleId(),
                getSchedule.getScheduleName(),
                getSchedule.getContents(),
                getSchedule.getAuthorName(),
                getSchedule.getModifiedAt()
        );
    }

    @Transactional
    public void deleteSchedule(Long scheduleId, DeleteScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new ScheduleNotFoundException()
        );

        if (!request.getSchedulePw().equals(schedule.getSchedulePw())) {
            throw new PasswordMismatchException();
        }
        scheduleRepository.deleteById(scheduleId);
    }
}
