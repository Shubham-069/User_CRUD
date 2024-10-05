package com.demo.user_crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.user_crud.entities.User;
import com.demo.user_crud.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new IllegalArgumentException("Invalid user Id:" + id);
        }
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        // Find the existing user by ID
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            User existingUser = optional.get();

            // Update fields
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setAddress(updatedUser.getAddress());

            // Save the updated user back to the database
            return userRepository.save(existingUser);
        } else {
            throw new IllegalArgumentException("Invalid user Id:" + id);
        }
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}