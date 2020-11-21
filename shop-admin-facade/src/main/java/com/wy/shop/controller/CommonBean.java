package com.wy.shop.controller;

import org.springframework.stereotype.Component;

/**
 * @author : WangYB
 * @time: 2020/11/21  09:38
 */
@Component
public class CommonBean {

    String name;

    public void setNaem(String name) {
        this.name = name;
    }

    public void initMethod() {
        System.out.println("初始化方法："+ name);
    }

}
