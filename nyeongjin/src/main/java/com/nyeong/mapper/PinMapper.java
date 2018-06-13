package com.nyeong.mapper;

import com.nyeong.entity.Pin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Title:  PinMapper
 * Description:
 *
 * @Author: Gwon NyeongJin
 * @Date: 2018/6/13 下午7:46
 * @Version: 1.0
 **/

@Mapper
public interface PinMapper {

    /**
     * 插入Pin
     * @param pin
     * @return
     */
    @Insert("insert into \"pin\"(\"planID\",\"pinLatitude\",\"pinLongitude\",\"pinTitle\",\"pinArrival\",\"pinDeparture\",\"pinStatus\",\"pinNotes\",\"isDelete\") values (#{planID},#{pinLatitude},#{pinLongitude},#{pinTTitle},#{pinArrival},#{pinDeparture},CAST(#{pinStatus} as \"enum_pinStatus\"),#{pinNotes},#{isDelete}")
    int insert(Pin pin);

}
