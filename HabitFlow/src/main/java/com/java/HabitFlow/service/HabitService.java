package com.java.HabitFlow.service;

import com.java.HabitFlow.dto.HabitDTO;
import com.java.HabitFlow.entity.Habit;
import com.java.HabitFlow.entity.User;
import com.java.HabitFlow.exception.ResourceNotFoundException;
import com.java.HabitFlow.repository.HabitRepository;
import com.java.HabitFlow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HabitService {

    private final HabitRepository habitRepository;
    private final UserRepository userRepository;

    public HabitDTO create(HabitDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Habit habit = Habit.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .user(user)
                .build();

        habit = habitRepository.save(habit);

        return toDTO(habit);
    }

    public List<HabitDTO> findByUser(Long userId) {
        return habitRepository.findByUserId(userId)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public HabitDTO findById(Long id) {
        Habit habit = habitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habit not found"));

        return toDTO(habit);
    }

    private HabitDTO toDTO(Habit habit) {
        return HabitDTO.builder()
                .id(habit.getId())
                .name(habit.getName())
                .description(habit.getDescription())
                .userId(habit.getUser().getId())
                .build();
    }
}