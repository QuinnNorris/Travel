package com.nyeong.mapper;

import com.nyeong.entity.Plan;
import com.nyeong.entity.Route;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface PlanMapper {


    /**
     * 根据 planID 查找对应的 plan
     * @param planID id
     * @return Plan
     */
    @Select("SELECT * FROM \"plan\" WHERE \"planID\" = #{id}")
    Plan getPlanByID(@Param("id") Integer planID);


    /**
     * 根据 planID 查找所有的 routes
     * @param planID
     * @return
     */
    @Select("SELECT * FROM route WHERE \"planID\" = #{planID} ORDER BY origin ")
    List<Route> getAllRouteByPlanID(@Param("planID") int planID);

    @Insert("INSERT INTO \"plan\"(\"mapID\",\"planName\") VALUES (#{mapID}, #{planName}) ")
    int insert(Plan plan);

    List<Plan> getByPlanIds(List<Integer> planIds);


//
//    ==============
//    以下仅作为参考写法
//    ==============

    /**
     * @return userinfoArray
     * @Description: 获取表中全部数据
     */
//    @Select("SELECT * FROM \"userInfo\"")
//    List<UserInfo> getAll();
//
//    /**
//     * @param userID
//     * @return userInfo
//     * @Description: 按userID来获取表中的一条数据
//     */
//    @Select("SELECT * FROM \"userInfo\" WHERE \"userID\" = #{userID}")
//    UserInfo getOne(@Param("userID") Integer userID);
//
//    /**
//     * @param userID
//     * @return myUserInfo
//     * @Description: 按userID来获取视图中的一条数据
//     */
//    @Select("SELECT * FROM \"myUserInfo\" WHERE \"userID\" = #{userID}")
//    MyUserInfo getOneFromView(@Param("userID") Integer userID);
//
//    /**
//     * @param userName
//     * @return userInfo
//     * @Description: 按userName来获取表中的一条数据
//     */
//    @Select("SELECT * FROM \"userInfo\" WHERE \"userName\" = #{userName}")
//    UserInfo getOneByUserName(@Param("userName") String userName);
//
//    /**
//     * @param phone
//     * @return userInfo
//     * @Description: 按phone来获取表中的一条数据
//     */
//    @Select("SELECT * FROM \"userInfo\" WHERE phone = #{phone}")
//    UserInfo getOneByPhone(@Param("phone") String phone);
//
//    /**
//     * @param email
//     * @return userInfo
//     * @Description: 按email来获取表中的一条数据
//     */
//    @Select("SELECT * FROM \"userInfo\" WHERE email = #{email}")
//    UserInfo getOneByEmail(@Param("email") String email);
//
//    /**
//     * @param userInfo
//     * @Description: 向表中插入一条数据
//     */
//    @Insert({"INSERT INTO \"userInfo\" (\"userName\", password, phone, email, \"userStatus\", \"nickName\") VALUES (#{userName}, #{password}, #{phone}, #{email}, CAST (#{userStatus} AS \"enum_userStatus\"), #{nickName})"})
//    int insert(UserInfo userInfo);
//
//    /**
//     * @param userID, newPassword
//     * @Description: 修改表中一条数据的password
//     */
//    @Update("UPDATE \"userInfo\" SET password = #{newPassword} WHERE \"userID\" =#{userID}")
//    int updatePassword(@Param("userID") Integer userID, @Param("newPassword") String newPassword);
//
//    /**
//     * @param userID
//     * @Description: 删除表中的一条数据
//     */
//    @Delete("DELETE FROM \"userInfo\" WHERE \"userID\" =#{userID}")
//    int delete(@Param("userID") Integer userID);

}
