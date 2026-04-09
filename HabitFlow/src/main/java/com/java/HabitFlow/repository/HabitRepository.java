package com.java.HabitFlow.repository;

import com.java.HabitFlow.entity.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitRepository extends JpaRepository<Habit, Long> {

    List<Habit> findByUserId(Long userId);
}