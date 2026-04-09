package com.java.HabitFlow.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HabitRecordDTO {

    private Long id;

    private LocalDate date;

    private Boolean completed;

    private Long habitId;
}