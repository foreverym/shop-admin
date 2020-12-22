package com.wy.shop.facade.impl;

import com.wy.shop.common.result.Result;
import com.wy.shop.common.util.PageBean;
import com.wy.shop.facade.OrderFacade;
import com.wy.shop.facade.config.CommonUrlConfig;
import com.wy.shop.facade.request.OrderMainRequest;
import com.wy.shop.facade.response.OrderPageResponse;
import com.wy.shop.service.OrderService;
import com.wy.shop.service.bo.OrderPageBo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangyibo
 */
@RestController
@RequestMapping(CommonUrlConfig.ORDER_URL_PREFIX)
public class OrderFacadeImpl implements OrderFacade {

    @Autowired
    private OrderService orderService;


    @GetMapping(CommonUrlConfig.URL_ORDER_MAIN_INFO)
    @ResponseBody
    @Override
    public Result<PageBean> queryPageOrder(@RequestParam Integer page,
                                           @RequestParam String logistic_code,
                                           @RequestParam Integer status) {
        List<OrderPageBo> orderPageBoList = orderService.queryPageOrder();
        List<OrderPageResponse> orderPageResponseList = orderPageBoList.stream().map(orderPageBo -> {
            OrderPageResponse orderPageResponse = new OrderPageResponse();
            BeanUtils.copyProperties(orderPageBo, orderPageResponse);
            return orderPageResponse;
        }).collect(Collectors.toList());
        PageBean pageBean = new PageBean();
        int count = orderService.queryOrderCount();
        pageBean.setData(orderPageResponseList);
        pageBean.setCount(count);
        pageBean.setPageSize(10);
        pageBean.setCurrentPage(page);
        return Result.success(pageBean);
    }
}
