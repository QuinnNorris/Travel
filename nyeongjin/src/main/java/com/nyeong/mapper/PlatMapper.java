package com.nyeong.mapper;

import com.nyeong.entity.Plan;
import com.nyeong.entity.Plat;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
public interface PlatMapper {
    /**
     * 插入Plat
     * @param plat
     * @return int
     */
    @Insert("insert into \"plat\" (\"planID\",\"centerLatitude\",\"centerLongitude\",\"mapIsAbroad\",\"mapZoom\") values (#{planID},#{centerLatitude},#{centerLongitude},#{mapIsAbroad},#{mapZoom})")
    int insert(Plat plat);

    /**
     * 修改Plat
     * @param plat
     * @return int
     */
    @Update("update \"plat\" set \"planID\"=#{planID},\"centerLatitude\"=#{centerLatitude},\"centerLongitude\"=#{centerLongitude},\"mapIsAbroad\"=#{mapIsAbroad},\"mapZoom\"=#{mapZoom} where \"mapID\"=#{mapID}")
    int update(Plat plat);

    @Select("select * from plat where \"planID\"=#{planID} and \"isDelete\"=false")
    Plat getByMapId(Plat plat);
}
