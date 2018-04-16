package com.nyeong.mapper;

import com.nyeong.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Title:  UserMapper
 * Description: 数据库表资源映射 用户
 *
 * @Author: quanningzhen
 * @Date: 2018/4/16 上午10:54
 * @Version: 1.0
 **/

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user")
    List<User> getAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    User getOne(Integer id);

    @Insert("INSERT INTO user(username,password) VALUES(#{username}, #{password})")
    void insert(User user);

    @Update("UPDATE user SET username=#{username} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);

}
