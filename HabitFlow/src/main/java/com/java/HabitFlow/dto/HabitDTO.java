package com.java.HabitFlow.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HabitDTO {

    private Long id;

    @NotBlank
    private String name;

    private String description;

    private Long userId;
}