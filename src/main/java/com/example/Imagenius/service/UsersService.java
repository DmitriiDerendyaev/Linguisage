package com.example.Imagenius.service;

import com.example.Imagenius.entity.Users;
import com.example.Imagenius.storage.UsersStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private final UsersStorage usersStorage;

    public UsersService(UsersStorage usersStorage) {
        this.usersStorage = usersStorage;
    }

    public Users findById(Long userId) {
        return usersStorage.findById(userId);
    }

    public List<Users> findAll() {
        return usersStorage.findAll();
    }

    public Users save(Users user) {
        return usersStorage.save(user);
    }

    public Users update(Users user) {
        return usersStorage.update(user);
    }

    public void delete(Long userId) {
        usersStorage.delete(userId);
    }
}
