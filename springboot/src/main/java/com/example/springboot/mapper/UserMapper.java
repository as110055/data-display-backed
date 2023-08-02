package com.example.springboot.mapper;

import com.example.springboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper

public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();

    @Insert("INSERT into user(username,password) VALUES (#{username},#{password})")
    int insert(User user);

    int update(User user);

    @Delete("delete from user where id = #{id}")
    Integer deleteById(@Param("id") Integer id);

    @Select("select * from user limit #{pageNum}, #{pageSize}")
    List<User> selectPage(Integer pageNum, Integer pageSize);

    @Select("select count(*) from country")
    Integer selectTotal();
}
