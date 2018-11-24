package com.lz.myspringboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.lz.myspringboot.dao.IUserDao;
import com.lz.myspringboot.model.User;
import com.lz.myspringboot.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: LZ
 * @Date: 2018/11/23 14: 10
 */
@Service
public class UserService implements IUserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    private final IUserDao userDao;

    @Autowired
    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Integer addUser(User user) {
        logger.info("UserService addUser record=>" + user.toString());
        return userDao.addUser(user);
    }

    @Transactional
    @Override
    public String deleteUserById(Integer userId) {
        logger.info("UserService deleteUserById id => " + userId);
        User user = userDao.findUserById(userId);
        String result;
        if (user == null) {
            result = "用户ID[" + userId + "]找不到!";
        } else {
            result = String.valueOf(userDao.deleteUserById(userId));
        }
        return result;
    }

    @Override
    public Integer updateUser(User user) {
        logger.info("UserService updateUser record=>" + user.toString());
        return userDao.updateUser(user);
    }

    @Override
    public User findUserById(Integer id) {
        logger.info("UserService findUserById id=>"+id);
        return userDao.findUserById(id);
    }

    @Override
    public List<User> findAll(Integer pageNumber, Integer pageSize) {
        logger.info("UserService findAll pageNumber => " + pageNumber + " => pageSize => " +pageSize);
        PageHelper.startPage(pageNumber, pageSize);
        List<User> userList =  userDao.findAll();
        logger.info("UserService findAll userList : " + userList.size());
        return userList;
    }

    @Override
    public User findUserByName(String name) {
        logger.info("UserService findUserByName name : " + name);
        return userDao.findUserByName(name);
    }


}
