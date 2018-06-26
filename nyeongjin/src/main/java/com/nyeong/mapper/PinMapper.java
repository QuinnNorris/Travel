package com.nyeong.mapper;

import com.nyeong.entity.Pin;
import org.apache.ibatis.annotations.*;

import java.util.List;

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
    @Insert("insert into \"pin\"(\"planID\",\"pinLatitude\",\"pinLongitude\",\"pinTitle\",\"pinArrival\",\"pinDeparture\",\"pinStatus\",\"pinNotes\",\"isDelete\",\"the_gemo\") values (#{planID},#{pinLatitude},#{pinLongitude},#{pinTitle},#{pinArrival},#{pinDeparture},CAST(#{pinStatus} as \"enum_pinStatus\"),#{pinNotes},#{isDelete},ST_GeomFromText('POINT(${pinLatitude} ${pinLongitude})',4326))")
    int insert(Pin pin);

    @Select("select * from pin where \"pinID\"=#{id} and \"isDelete\"=false")
    Pin getPinByID(@Param("id") int id);

    @Update("update pin set \"planID\"=#{planID},\"pinLatitude\"=#{pinLatitude},\"pinLongitude\"=#{pinLongitude},\"pinTitle\"=#{pinTitle},\"pinArrival\"=#{pinArrival},\"pinDeparture\"=#{pinDeparture},\"pinStatus\"=CAST(#{pinStatus} AS \"enum_pinStatus\"),\"pinNotes\"=#{pinNotes},\"isDelete\"=#{isDelete} where \"pinID\"=#{pinID}")
    int updateBypinId(Pin pin);

    @Select("select * from pin where \"planID\"=#{planID} and \"isDelete\"=false")
    List<Pin> getByPlanId(Pin pin);
}
