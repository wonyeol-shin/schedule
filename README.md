# schedule (일정 관리 과제)

---
## ERD

*ERD링크*
<iframe width="600" height="336" src="https://www.erdcloud.com/p/vm5b255nF7nu29Ye7" frameborder="0" allowfullscreen></iframe>

*SQL쿼리*

DROP TABLE IF EXISTS `schedules`;

CREATE TABLE `schedules` (
	`scheduleId`	Long	NOT NULL,
	`scheduleName`	varchar(12)	NOT NULL,
	`contents`	varchar(512)	NOT NULL,
	`authorName`	varchar(50)	NOT NULL,
	`schedulePw`	varchar(50)	NOT NULL,
	`createdAt`	datetime	NOT NULL,
	`modifedAt`	datetime	NOT NULL
);

ALTER TABLE `schedules` ADD CONSTRAINT `PK_SCHEDULE` PRIMARY KEY (
	`scheduleId`
);

---
## API 명세서

| 기능 | 메서드 | URL | 요청예시 | 응답예시 |
|---|---|---|---|---|
| 일정 단건조회 | `GET` | `/schedules/{schedule-id}` | `/schedules/1` | `{ "schedule-id" : 1,<br> "schedule-name" : "배드로 좋아, 탕후루 좋아", <br> "contents"   }` | 
 
