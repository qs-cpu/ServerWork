package com.xzy212306259.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzy212306259.demo.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}