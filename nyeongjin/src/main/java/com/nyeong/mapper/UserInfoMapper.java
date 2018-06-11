package com.nyeong.mapper;

import com.nyeong.entity.MyUserInfo;
import com.nyeong.entity.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Title: UserInfoMapper
 * @Description: UserInfo表和myUserInfo视图的数据库表资源映射
 * @Author: Felix
 * @Date: 6/1/2018 0:19
 * @Version: 1.0
 **/

@Mapper
public interface UserInfoMapper {

    /**
     * @Description: 获取表中全部数据
     * @return userinfoArray
     */
    @Select("SELECT * FROM \"userInfo\"")
    List<UserInfo> getAll();

    /**
     * @Description: 按userID来获取表中的一条数据
     * @param userID
     * @return userInfo
     */
    @Select("SELECT * FROM \"userInfo\" WHERE \"userID\" = #{userID}")
    UserInfo getOne(@Param("userID") Integer userID);

    /**
     * @Description: 按userID来获取视图中的一条数据
     * @param userID
     * @return myUserInfo
     */
    @Select("SELECT * FROM \"myUserInfo\" WHERE \"userID\" = #{userID}")
    MyUserInfo getOneFromView(@Param("userID") Integer userID);

    /**
     * @Description: 按userName来获取表中的一条数据
     * @param userName
     * @return userInfo
     */
    @Select("SELECT * FROM \"userInfo\" WHERE \"userName\" = #{userName}")
    UserInfo getOneByUserName(@Param("userName") String userName);

    /**
     * @Description: 按phone来获取表中的一条数据
     * @param phone
     * @return userInfo
     */
    @Select("SELECT * FROM \"userInfo\" WHERE phone = #{phone}")
    UserInfo getOneByPhone(@Param("phone") String phone);

    /**
     * @Description: 按email来获取表中的一条数据
     * @param email
     * @return userInfo
     */
    @Select("SELECT * FROM \"userInfo\" WHERE email = #{email}")
    UserInfo getOneByEmail(@Param("email") String email);

    /**
     * @Description: 向表中插入一条数据
     * @param userInfo
     */
    @Insert({"INSERT INTO \"userInfo\" (\"userName\", password, phone, email, \"userStatus\") VALUES (#{userName}, #{password}, #{phone}, #{email}, CAST (#{userStatus} AS \"enum_userStatus\"))"})
    int insert(UserInfo userInfo);

    /**
     * @Description: 修改表中一条数据的password
     * @param userID, newPassword
     */
    @Update("UPDATE \"userInfo\" SET password = #{newPassword} WHERE \"userID\" =#{userID}")
    int updatePassword(@Param("userID") Integer userID, @Param("newPassword") String newPassword);

    /**
     * @Description: 删除表中的一条数据
     * @param userID
     */
    @Delete("DELETE FROM \"userInfo\" WHERE \"userID\" =#{userID}")
    int delete(@Param("userID") Integer userID);

    UserInfo getOneByUserNameAndPassword(String userName, String oldPassword);

    UserInfo getOneByPhoneAndPassword(String account, String password);

    UserInfo getOneByUserIDAndPassword(int userID, String oldPassword);
}
