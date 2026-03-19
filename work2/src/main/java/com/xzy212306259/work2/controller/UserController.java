package com.xzy212306259.work2.controller;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xzy212306259.work2.entity.User;

@RestController
@RequestMapping("/api/users")
public class UserController{
    private final List<User> users = new ArrayList<>();
    private long nextId =1;
    public List<User> getAllUsers() {
        return users;
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }
    @PostMapping
    public User createUser(@RequestBody User user) {
        user.setId((int) nextId++);
        users.add(user);
        return user;
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
         User existingUser = getUser(id);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setAge(user.getAge());
        }
        return existingUser;
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        User user = getUser(id);
        if (user != null) {
            users.remove(user);
            return "用户删除成功";
        }
        return "用户不存在";
    }
   }
