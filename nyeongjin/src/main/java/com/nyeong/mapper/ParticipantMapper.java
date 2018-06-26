package com.nyeong.mapper;

import com.nyeong.entity.Participants;
import com.nyeong.entity.Plan;
import org.apache.ibatis.annotations.*;

import java.util.List;

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

    @Select("select \"planID\" from participants where \"participantID\"=#{participantID} and \"isDelete\"=false")
    int getPlanIDByuserID(@Param("participantID") Integer userID);

    @Select("select * from participants where \"planID\"=#{planID} and \"isDelete\"=false" )
    List<Participants> getByPlanId(Participants participants);

    @Select("select * from participants where \"planID\"=#{planID} and \"participantID\"=#{participantID} and \"isDelete\"=false")
    Participants getByPlanIdAndParticipantId(Participants participants);

    @Insert("insert into participants(\"planID\",\"participantID\",\"participantAuthorization\",\"isDelete\")values(#{planID},#{participantID},CAST(#{participantAuthorizationType} as \"enum_authorization\"),#{isDelete})")
    int insert(Participants participants);

    @Update("update participants set \"planID\"=#{planID},\"participantAuthorization\"=CAST(#{participantAuthorizationType} as \"enum_authorization\"),\"isDelete\"=#{isDelete} where \"participantID\"=#{participantID}")
    int updateParticipants(Participants participants);

}