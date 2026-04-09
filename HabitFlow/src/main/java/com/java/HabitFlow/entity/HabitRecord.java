package com.java.HabitFlow.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "habit_records")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HabitRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Boolean completed;

    @ManyToOne
    @JoinColumn(name = "habit_id", nullable = false)
    private Habit habit;
}