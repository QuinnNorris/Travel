package com.nyeong.service;


import com.nyeong.annotation.Logged;
import com.nyeong.entity.Pin;
import com.nyeong.mapper.PinMapper;
import com.nyeong.util.BaseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PinService {

    @Autowired
    private PinMapper pinMapper;

    public PinService(PinMapper pinMapper) {
        this.pinMapper = pinMapper;
    }

    @Transactional
    public BaseJson addPin(Pin pin) {
        BaseJson baseJson = new BaseJson();

        return baseJson;
    }

    @Transactional
    public BaseJson deleteById(Integer id) {
        BaseJson baseJson = new BaseJson();

        return baseJson;
    }

    @Transactional
    public BaseJson update(Pin pin) {
        BaseJson baseJson = new BaseJson();
        return baseJson;
    }

    @Transactional
    public BaseJson getPinsByPinID(Integer id) {
        BaseJson baseJson = new BaseJson();
        return baseJson;
    }



}
