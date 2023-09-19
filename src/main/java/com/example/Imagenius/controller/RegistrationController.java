package com.example.Imagenius.controller;

import com.example.Imagenius.model.User;
import com.example.Imagenius.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//TODO: these are test endpoints to show the database working
@RequestMapping("registration/")
public class RegistrationController {
    UserServiceImpl userService;

    @Autowired
    public RegistrationController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("all")
    public List<User> getUser(){
        return userService.getAllUsers();
    }

    @GetMapping("byId/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("byEmail/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
        // Добавьте реализацию поиска пользователя по email в вашем сервисе
        return userService.findByEmail(email);
    }

    @PostMapping()
    public Long registration(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("delete/{id}")
    public String deleteUserById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            userService.deleteById(id);
            return "User with ID " + id + " has been deleted.";
        } else {
            return "User with ID " + id + " not found.";
        }
    }

}
