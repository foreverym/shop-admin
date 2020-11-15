package com.wy.shop.service.impl;

import com.wy.shop.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wy.shop.entity.Admin;
import com.wy.shop.mapper.AdminMapper;
import com.wy.shop.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public Order getOrder() {
        return adminMapper.getOrder();
    }
}
