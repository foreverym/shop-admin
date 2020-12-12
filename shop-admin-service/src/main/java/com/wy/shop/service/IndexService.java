package com.wy.shop.service;

import com.wy.shop.service.bo.IndexMainBo;
import com.wy.shop.service.bo.PanelBo;

/**
 * @author : WangYB
 * @time: 2020/12/11  11:01
 */
public interface IndexService {

    public PanelBo queryIndexPanelInfo();

    public IndexMainBo getIndexMainInfo(int pindex);

}
