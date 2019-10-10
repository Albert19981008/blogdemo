package com.example.blog.dao;

import com.example.blog.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserDao {

    @Select("select * from user where username = #{username}")
    User loadUserByUsername(String username);
}
