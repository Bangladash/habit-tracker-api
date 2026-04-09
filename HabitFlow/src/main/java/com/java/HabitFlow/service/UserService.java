package com.java.HabitFlow.service;

import com.java.HabitFlow.dto.UserDTO;
import com.java.HabitFlow.entity.User;
import com.java.HabitFlow.exception.ApiException;
import com.java.HabitFlow.exception.ResourceNotFoundException;
import com.java.HabitFlow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDTO create(UserDTO dto) {
        userRepository.findByEmail(dto.getEmail())
                .ifPresent(u -> {
                    throw new ApiException("Email already exists");
                });

        User user = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .build();

        user = userRepository.save(user);

        return toDTO(user);
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public UserDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return toDTO(user);
    }

    private UserDTO toDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}