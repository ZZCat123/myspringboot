package com.lz.myspringboot.service;

import com.lz.myspringboot.model.User;

import java.util.List;

/**
 * @Author: LZ
 * @Date: 2018/11/23 14: 08
 */
public interface IUserService {

    Integer addUser(User user);

    String deleteUserById(Integer userId);

    Integer updateUser(User user);

    User findUserById(Integer id);

    List<User> findAll(Integer pageNumber, Integer pageSize);

    User findUserByName(String name);

}
