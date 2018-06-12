package com.nyeong.mapper;

import com.nyeong.entity.Plat;
import org.apache.ibatis.annotations.Mapper;

/**
 * Title:  PlatMapper
 * Description:
 *
 * @Author: Gwon NyeongJin
 * @Date: 2018/6/12 下午4:37
 * @Version: 1.0
 **/

@Mapper
public interface PlatMapper {

    int insert(Plat plat);

}
