package com.xzy_212306259.demo.controller;

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

import com.xzy_212306259.demo.common.Result;
import com.xzy_212306259.demo.common.ResultCode;
import com.xzy_212306259.demo.entity.User;

@RestController
@RequestMapping("/api/users")
public class UserController{
    private final List<User> users = new ArrayList<>();
    private long nextId =1;
    @GetMapping
    public Result<List<User>> getAllUsers() {
        return Result.success(users);
    }
    @GetMapping("/{id}")
    public Result<User> getUser(@PathVariable int id) {
        User user = users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
        
        if (user == null) {
            return Result.error(ResultCode.SYSTEM_BUSY);
        }
        return Result.success(user);
    }
    @PostMapping
    public Result<User> createUser(@RequestBody User user) {
        user.setId((int) nextId++);
        users.add(user);
        return Result.success(user);
    }
    @PutMapping("/{id}")
    public Result<User> updateUser(@PathVariable int id, @RequestBody User user) {
        User existingUser = users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
        
        if (existingUser == null) {
            return Result.error(ResultCode.SYSTEM_BUSY);
        }
        
        existingUser.setName(user.getName());
        existingUser.setAge(user.getAge());
        return Result.success(existingUser);
    }
    @DeleteMapping("/{id}")
    public Result<String> deleteUser(@PathVariable int id) {
        User user = users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
        
        if (user == null) {
            return Result.error(ResultCode.SYSTEM_BUSY);
        }
        
        users.remove(user);
        return Result.success("用户删除成功");
    }
}