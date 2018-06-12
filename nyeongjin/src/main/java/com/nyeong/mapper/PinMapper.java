package com.nyeong.mapper;

import com.nyeong.entity.Pin;
import org.apache.ibatis.annotations.Mapper;

/**
 * Title:  PinMapper
 * Description:
 *
 * @Author: Gwon NyeongJin
 * @Date: 2018/6/12 下午6:21
 * @Version: 1.0
 **/

@Mapper
public interface PinMapper {

    int insert(Pin pin);

}
