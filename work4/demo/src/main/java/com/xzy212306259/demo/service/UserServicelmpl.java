package com.xzy212306259.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzy212306259.demo.common.Result;
import com.xzy212306259.demo.common.ResultCode;
import com.xzy212306259.demo.dto.UserDTO;
import com.xzy212306259.demo.entity.User;
import com.xzy212306259.demo.mapper.UserMapper;


@Service
public class UserServicelmpl implements UserService {
    private static final Map<String, String> userDb = new HashMap<>();
    
    @Autowired
    private UserMapper userMapper;
    @Override
    public Result<String> register(UserDTO userDTO) {
        if (userDb.containsKey(userDTO.getUsername())) {
            return Result.error(ResultCode.USER_HAS_EXISTED);
        }
        userDb.put(userDTO.getUsername(), userDTO.getPassword());
        return Result.success("注册成功");
    }
    @Override
    public Result<String> login(UserDTO userDTO) {
        if (!userDb.containsKey(userDTO.getUsername())) {
            return Result.error(ResultCode.USER_NOT_EXIST);
        }
        if (!userDb.get(userDTO.getUsername()).equals(userDTO.getPassword())) {
            return Result.error(ResultCode.PASSWORD_ERROR);
        }
        return Result.success("登录成功");
    }
    
    @Override
    public Result<User> getUserById(Long id) {
        User user = userMapper.selectById(id);
        if (user == null) {
            return Result.error(ResultCode.USER_NOT_EXIST);
        }
        return Result.success(user);
    }
}