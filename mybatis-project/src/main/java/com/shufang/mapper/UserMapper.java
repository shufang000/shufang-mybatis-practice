package com.shufang.mapper;


import com.shufang.pojo.User;

public interface UserMapper {

    User getById(String id);

    Integer insert(User user);
}
