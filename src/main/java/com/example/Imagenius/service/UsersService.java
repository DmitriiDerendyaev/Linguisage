package com.example.Imagenius.service;

import com.example.Imagenius.entity.Users;
import com.example.Imagenius.storage.UsersStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final BCryptPasswordEncoder passwordEncoder;

    private final UsersStorage usersStorage;

    public UsersService(UsersStorage usersStorage, BCryptPasswordEncoder passwordEncoder) {
        this.usersStorage = usersStorage;
        this.passwordEncoder = passwordEncoder;
    }

    public Users findById(Long userId) {
        return usersStorage.findById(userId);
    }

    public List<Users> findAll() {
        return usersStorage.findAll();
    }

    public Users save(Users user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return usersStorage.save(user);
    }

    public Users update(Users user) {
        return usersStorage.update(user);
    }

    public void delete(Long userId) {
        usersStorage.delete(userId);
    }

    public Optional<Users> findByEmail(String email) {
        return usersStorage.findByEmail(email);
    }
}
