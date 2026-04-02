package com.xzy212306259.demo.service;

import com.xzy212306259.demo.common.Result;
import com.xzy212306259.demo.dto.UserDTO;
import com.xzy212306259.demo.entity.User;

public interface UserService {
    Result<String> register(UserDTO userDTO);
    Result<String> login(UserDTO userDTO);
    Result<User> getUserById(Long id);
}