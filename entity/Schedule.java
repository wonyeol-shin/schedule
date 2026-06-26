package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;
    @Column(length = 12, nullable = false)
    private String scheduleName;
    @Column(length = 512, nullable = false)
    private String contents;
    @Column(length = 50, nullable = false)
    private String authorName;
    @Column(length = 50, nullable = false)
    private String schedulePw;

    public Schedule(String scheduleName, String contents, String authorName, String schedulePw) {
        this.scheduleName = scheduleName;
        this.contents = contents;
        this.authorName = authorName;
        this.schedulePw = schedulePw;
    }

    public void updateSchedule(String scheduleName, String authorName) {
        this.scheduleName = scheduleName;
        this.authorName = authorName;
    }

}
