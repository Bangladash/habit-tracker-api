package com.java.HabitFlow.controller;

import com.java.HabitFlow.dto.HabitDTO;
import com.java.HabitFlow.service.HabitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habits")
@RequiredArgsConstructor
public class HabitController {

    private final HabitService habitService;

    @PostMapping
    public HabitDTO create(@RequestBody @Valid HabitDTO dto) {
        return habitService.create(dto);
    }

    @GetMapping("/user/{userId}")
    public List<HabitDTO> findByUser(@PathVariable Long userId) {
        return habitService.findByUser(userId);
    }

    @GetMapping("/{id}")
    public HabitDTO findById(@PathVariable Long id) {
        return habitService.findById(id);
    }
}