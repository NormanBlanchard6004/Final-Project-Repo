package com.recipeshare.service;

import com.recipeshare.entity.User;
import com.recipeshare.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    //@Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
    	User user = userRepository.findById(id)
    	        .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
