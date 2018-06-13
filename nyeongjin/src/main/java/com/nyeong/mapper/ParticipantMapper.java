package com.nyeong.mapper;

import com.nyeong.entity.Plan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Title:  PlatMapper
 * Description:
 *
 * @Author: Gwon NyeongJin
 * @Date: 2018/6/13 下午7:42
 * @Version: 1.0
 **/


@Mapper
public interface ParticipantMapper {

    @Select("select \"planID\" from participants where \"userID\"=#{userID} and \"isDelete\"=false")
    int getPlanIDByuserID(@Param("userID") Integer userID);


}