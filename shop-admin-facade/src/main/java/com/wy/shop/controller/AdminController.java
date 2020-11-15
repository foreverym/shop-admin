package com.wy.shop.controller;

import com.wy.shop.entity.Order;
import com.wy.shop.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
public class AdminController {

    public static Logger log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @GetMapping("/getAdmin")
    @ResponseBody
    public Order getAdmin() {
        log.info(">>>>>>>>>>>>>>>>>>>>>执行了" );
        Order order = adminService.getOrder();
        return order;
    }

}
