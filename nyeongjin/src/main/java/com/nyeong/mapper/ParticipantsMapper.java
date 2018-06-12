package com.nyeong.mapper;

import com.nyeong.entity.Participants;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Title:  ParticipantsMapper
 * Description:
 *
 * @Author: Gwon NyeongJin
 * @Date: 2018/6/12 下午1:19
 * @Version: 1.0
 **/

@Mapper
public interface ParticipantsMapper {


    List<Participants> getPlanIDByuserID(Participants participants);

}
