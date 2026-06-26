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
    @Column(length = 50, nullable = false, unique = true)
    private String authorName;
    @Column(length = 50, nullable = false)
    private String schedulePw;

}
