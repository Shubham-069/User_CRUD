package com.demo.user_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.demo.user_crud.entities.User;
import com.demo.user_crud.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // Show the home page with the list of users
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    // Show form to add a new user
    @GetMapping("/add")
    public String showAddUserForm(User user) {
        return "add-user";
    }

    // Add new user
    @PostMapping("/add")
    public String addUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    // Show form to edit user details
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit-user";
    }

    // Update user details
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    // Delete user
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }
}