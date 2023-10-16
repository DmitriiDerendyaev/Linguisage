//package com.example.Imagenius.service;
//
//import com.example.Imagenius.model.User;
//import com.example.Imagenius.repository.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserServiceImpl implements UserService{
//
//    private final UserRepo userRepo;
//
//    @Autowired
//    public UserServiceImpl(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }
//    @Override
//    public Long save(User user) {
//        return userRepo.save(user).getId();
//    }
//
//    @Override
//    public Optional<User> findById(Long id) {
//        return userRepo.findById(id);
//    }
//
//    @Override
//    public Long deleteById(Long id) {
//        userRepo.deleteById(id);
//        return id;
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        return userRepo.findAll();
//    }
//
//    @Override
//    public Optional<User> findByEmail(String email) {
//        return userRepo.findByEmail(email);
//    }
//
//
//}
//
//
//
//
//
//
//
//
//
//
