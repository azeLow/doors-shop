package ru.shop.doors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shop.doors.model.User;
import ru.shop.doors.service.UserService;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @PostMapping(value = "/user/create")
    public void createUser(@RequestBody User userFromFronted){
        userService.createUser(userFromFronted);
    }

    @GetMapping(value = "/createUser/get")
    public User getUserById(@RequestParam Long id){
        return userService.getUserById(id);
    }

    @DeleteMapping(value = "/user/delete/{id}")
    public void delete(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
