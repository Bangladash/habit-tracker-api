package com.java.HabitFlow.repository;

import com.java.HabitFlow.entity.HabitRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HabitRecordRepository extends JpaRepository<HabitRecord, Long> {

    List<HabitRecord> findByHabitId(Long habitId);

    Optional<HabitRecord> findByHabitIdAndDate(Long habitId, LocalDate date);
}