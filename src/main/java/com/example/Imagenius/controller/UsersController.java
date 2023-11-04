package com.example.Imagenius.controller;

import com.example.Imagenius.dto.RegistrationResponseDTO;
import com.example.Imagenius.entity.Users;
import com.example.Imagenius.service.UsersService;
import com.example.Imagenius.viewJSON.RegistrationView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UsersController(UsersService usersService, BCryptPasswordEncoder passwordEncoder) {
        this.usersService = usersService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @JsonView(RegistrationView.class) @RequestBody Users user) {
        Optional<Users> optionalUsers = usersService.findByEmail(user.getEmail());
        if (optionalUsers.isPresent()) {
            Users existingUser = optionalUsers.get();
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Пользователь с таким email уже существует");
        }
        Users newUser = usersService.save(user);

        RegistrationResponseDTO responseDTO = new RegistrationResponseDTO(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }



    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody Users user) {
        Optional<Users> optionalUsers = usersService.findByEmail(user.getEmail());
        if (optionalUsers.isPresent()) {
            Users existingUser = optionalUsers.get();
            // Проверка пароля с использованием BCrypt
            if (passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
                return ResponseEntity.ok(existingUser);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Неверный пароль");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Пользователь не найден");
        }
    }


    @PutMapping("/updateByEmail")
    public ResponseEntity<?> updateFieldsByEmail(@Valid @RequestBody Users user) {
        Optional<Users> optionalUsers = usersService.findByEmail(user.getEmail());
        if (optionalUsers.isPresent()) {
            Users existingUser = optionalUsers.get();
            existingUser.setUsername(user.getUsername());
            existingUser.setBirthday(user.getBirthday());
            existingUser.setBatchSize(user.getBatchSize());
            existingUser.setRegisteredAt(user.getRegisteredAt());
            existingUser.setThemeMode(user.getThemeMode());
            Users updatedUser = usersService.update(existingUser);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Пользователь не найден");
        }
    }


    @GetMapping("/{userId}")
    public Users getUserById(@PathVariable Long userId) {
        return usersService.findById(userId);
    }

    @GetMapping("/all")
    public List<Users> getAllUsers() {
        return usersService.findAll();
    }

    @PostMapping("/add")
    public Users addUser(@Valid @RequestBody Users user) {
        return usersService.save(user);
    }

    @PutMapping("/update")
    public Users updateUser(@Valid @RequestBody Users user) {
        return usersService.update(user);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        usersService.delete(userId);
    }
}
