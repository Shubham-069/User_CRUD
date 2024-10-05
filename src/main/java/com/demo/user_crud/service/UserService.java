package com.demo.user_crud.service;

import java.util.List;

import com.demo.user_crud.entities.User;

public interface UserService {

    // to get a list of all users
    List<User> getAllUsers();

    // to add a new user
    User saveUser(User user);

    // to get a user by id
    User getUserById(Long id);

    // to update a existing user
    User updateUser(Long id, User updatedUser);

    // to delete a user
    void deleteUserById(Long id);

}
