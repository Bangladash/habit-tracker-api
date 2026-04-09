package com.java.HabitFlow.service;


import com.java.HabitFlow.dto.HabitRecordDTO;
import com.java.HabitFlow.entity.Habit;
import com.java.HabitFlow.entity.HabitRecord;
import com.java.HabitFlow.exception.ApiException;
import com.java.HabitFlow.exception.ResourceNotFoundException;
import com.java.HabitFlow.repository.HabitRecordRepository;
import com.java.HabitFlow.repository.HabitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HabitRecordService {

    private final HabitRecordRepository habitRecordRepository;
    private final HabitRepository habitRepository;

    public HabitRecordDTO markHabit(Long habitId, boolean completed) {
        Habit habit = habitRepository.findById(habitId)
                .orElseThrow(() -> new ResourceNotFoundException("Habit not found"));

        LocalDate today = LocalDate.now();

        habitRecordRepository.findByHabitIdAndDate(habitId, today)
                .ifPresent(r -> {
                    throw new ApiException("Habit already marked today");
                });

        HabitRecord record = HabitRecord.builder()
                .habit(habit)
                .date(today)
                .completed(completed)
                .build();

        record = habitRecordRepository.save(record);

        return toDTO(record);
    }

    public List<HabitRecordDTO> getHistory(Long habitId) {
        return habitRecordRepository.findByHabitId(habitId)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    private HabitRecordDTO toDTO(HabitRecord record) {
        return HabitRecordDTO.builder()
                .id(record.getId())
                .date(record.getDate())
                .completed(record.getCompleted())
                .habitId(record.getHabit().getId())
                .build();
    }
}