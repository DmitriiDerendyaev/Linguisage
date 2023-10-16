package com.example.Imagenius.controller;

import com.example.Imagenius.entity.Users;
import com.example.Imagenius.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
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
    public Users addUser(@RequestBody Users user) {
        return usersService.save(user);
    }

    @PutMapping("/update")
    public Users updateUser(@RequestBody Users user) {
        return usersService.update(user);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        usersService.delete(userId);
    }
}
