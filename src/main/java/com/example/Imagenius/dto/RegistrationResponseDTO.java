package com.example.Imagenius.dto;

import com.example.Imagenius.entity.Users;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class RegistrationResponseDTO {
    private Long userId;
    private String email;
    private String username;
    private LocalDate registeredAt;

    public RegistrationResponseDTO(Users user) {
        this.userId = user.getUserId();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.registeredAt = user.getRegisteredAt();
    }

}
