package com.lz.myspringboot.dao;

import com.lz.myspringboot.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: LZ
 * @Date: 2018/11/23 13: 54
 */
@Mapper
public interface IUserDao {

    @Insert("insert into user values(#{id}, #{name}, #{password})")
    Integer addUser(User user);

    @Delete("delete from user where id = #{userId}")
    Integer deleteUserById(@Param("userId") Integer userId);

    @Update("update user set name=#{name}, password=#{password} where id=#{id}")
    Integer updateUser(User user);

    @Select("select * from user where id=#{id}")
    User findUserById(Integer id);

    @Select("select * from user")
    List<User> findAll();

    @Select("Select * from user where name=#{name}")
    User findUserByName(String name);

}
