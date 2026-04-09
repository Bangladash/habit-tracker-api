package com.java.HabitFlow.controller;

import com.java.HabitFlow.dto.HabitRecordDTO;
import com.java.HabitFlow.service.HabitRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
@RequiredArgsConstructor
public class HabitRecordController {

    private final HabitRecordService habitRecordService;

    @PostMapping("/habit/{habitId}")
    public HabitRecordDTO markHabit(
            @PathVariable Long habitId,
            @RequestParam boolean completed
    ) {
        return habitRecordService.markHabit(habitId, completed);
    }

    @GetMapping("/habit/{habitId}")
    public List<HabitRecordDTO> getHistory(@PathVariable Long habitId) {
        return habitRecordService.getHistory(habitId);
    }
}