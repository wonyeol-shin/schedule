# schedule (일정 관리 과제)

---
## ERD

**ERD링크**<br>
``<iframe width="600" height="336" src="https://www.erdcloud.com/p/vm5b255nF7nu29Ye7" frameborder="0" allowfullscreen></iframe>``
<br><br>
**SQL쿼리** 

```SQL
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
```

---
## API 명세서 : 일정 관리 (Schedule)
Version: 1.0.0<br>
Base URL : http://localhost:8080

### 📌 일정 조회(단건)

**Request - 요청**
* Method : `GET`
* URL : `/schedules/{schedule-id}`

| 속성 | 타입 | 필수 | 설명 |
|---|---|---|---|
| schedule-id | int | yes | 원하는 일정 조회 | 

**Response - 응답**
* Status Code : `200`
* Comment : 조회 성공
* Response Body : `application/json`
* Body : 
```JSON
{
  "schedule-id" : 1,
  "schedule-name" : "타대오다 해야될 것",
  "contents" : "배드로 숑디와 탕후루 먹기",
  "authorName" : "타대오",
  "createdAt" : 2026062,
}
```

### 📌 일정 조회(다건)

**Request - 요청**
* Method : `GET`
* URL : `/schedules`


**Response - 응답**
* Status Code : `200`
* Comment : 조회 성공
* Response Body : `application/json`
* Body : 
```JSON
[
{
  "schedule-id" : 1,
  "schedule-name" : "타대오가 해야될 것",
  "contents" : "배드로 숑디와 탕후루 먹기",
  "authorName" : "타대오",
  "createdAt" : 2026062,
},
{
  "schedule-id" : 1,
  "schedule-name" : "타대오다 해야될 것",
  "contents" : "배드로 숑디와 탕후루 먹기",
  "authorName" : "타대오",
  "createdAt" : 2026062,
}
]
```




