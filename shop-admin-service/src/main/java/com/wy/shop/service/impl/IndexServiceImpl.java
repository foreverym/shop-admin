package com.wy.shop.service.impl;

import com.wy.shop.common.util.DateUtil;
import com.wy.shop.dao.GoodsDao;
import com.wy.shop.dao.OrderDao;
import com.wy.shop.dao.UserDao;
import com.wy.shop.dao.entity.OrderIndexMain;
import com.wy.shop.dao.entity.UserIndexMain;
import com.wy.shop.dao.mapper.GoodsMapper;
import com.wy.shop.service.IndexService;
import com.wy.shop.service.bo.IndexMainBo;
import com.wy.shop.service.bo.PanelBo;
import com.wy.shop.service.bo.UserIndexMainBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : WangYB
 * @time: 2020/12/11  11:06
 */
@Service
public class IndexServiceImpl implements IndexService {

    public static final Logger logger = LoggerFactory.getLogger(IndexServiceImpl.class);

    @Autowired
    private UserDao userDao;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private OrderDao orderDao;

    @Override
    public PanelBo queryIndexPanelInfo() {
        PanelBo panelBo = new PanelBo();
        Integer userCount = userDao.queryUserCount();
        Integer goodsCount = goodsDao.queryGoodsCount();
        Integer orderCount = orderDao.queryPrepareDeliveryOrder();
        panelBo.setGoodsOnsale(goodsCount);
        panelBo.setUser(userCount);
        panelBo.setOrderToDelivery(orderCount);
        return panelBo;
    }

    @Override
    public IndexMainBo getIndexMainInfo(int pindex) {
        OrderIndexMain orderIndexMain = orderDao.queryIndexMainOrderInfo();
        logger.info(">>>>>>>>>>>>>>>>" + orderIndexMain);
        List<UserIndexMain> userIndexMainList = userDao.queryUserList();
        logger.info(">>>>>>>>>>>>>>>" + userIndexMainList);
        long todayDateTime = DateUtil.getInstance().getTodayDateTime();
        long datetime = 0;
        //今天
        if (pindex == 0) {
            datetime = todayDateTime;
        }
        //昨天
        if (pindex == 1) {
            datetime = todayDateTime - 3600 * 24 * 2;
        }
        //最近七天
        if (pindex == 2) {
            datetime = todayDateTime - 3600 * 24 * 7;
        }
        //最近30天
        if (pindex == 3) {
            datetime = todayDateTime - 3600 * 24 * 30;
        }
        final long compareDateTime = datetime;
        List<UserIndexMainBo> collect = userIndexMainList.stream().map(userIndexMain -> {
            UserIndexMainBo userIndexMainBo = new UserIndexMainBo();
            BeanUtils.copyProperties(userIndexMain, userIndexMainBo);
            return userIndexMainBo;
        }).collect(Collectors.toList());

        List<UserIndexMainBo> newData = collect.stream()
                .filter(userIndexMainBo -> userIndexMainBo.getRegister_time() > compareDateTime)
                .collect(Collectors.toList());
        List<UserIndexMainBo> oldData = collect.stream()
                .filter(userIndexMainBo -> userIndexMainBo.getRegister_time() < compareDateTime)
                .collect(Collectors.toList());

        IndexMainBo indexMainBo = new IndexMainBo();
        indexMainBo.setAddCart(orderIndexMain.getAddCart());
        indexMainBo.setAddOrderNum(orderIndexMain.getAddOrderNum());
        indexMainBo.setAddOrderSum(orderIndexMain.getAddOrderSum());
        indexMainBo.setNewUser(newData.size());
        indexMainBo.setNewData(newData);
        indexMainBo.setOldUser(oldData.size());
        indexMainBo.setOldData(oldData);
        indexMainBo.setPayOrderNum(orderIndexMain.getPayOrderNum());
        indexMainBo.setPayOrderSum(orderIndexMain.getPayOrderSum());

        return indexMainBo;
    }




}
