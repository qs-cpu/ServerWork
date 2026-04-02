package com.xzy212306259.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xzy212306259.demo.common.Result;
import com.xzy212306259.demo.common.ResultCode;
import com.xzy212306259.demo.dto.UserDTO;
import com.xzy212306259.demo.entity.User;
import com.xzy212306259.demo.mapper.UserMapper;


@Service
public class UserServicelmpl implements UserService {
    
    @Autowired
    private UserMapper userMapper;
    @Override
    public Result<String> register(UserDTO userDTO) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, userDTO.getUsername());
        User user = userMapper.selectOne(queryWrapper);
        if (user != null) {
            return Result.error(ResultCode.USER_HAS_EXISTED);
        }
        User newUser = new User();
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(userDTO.getPassword());
        userMapper.insert(newUser);
        return Result.success("注册成功");
    }
    @Override
    public Result<String> login(UserDTO userDTO) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, userDTO.getUsername());
        queryWrapper.eq(User::getPassword, userDTO.getPassword());
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
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