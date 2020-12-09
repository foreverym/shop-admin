package com.wy.shop.facade.impl;

import com.wy.shop.common.result.Result;
import com.wy.shop.facade.IndexFacade;
import com.wy.shop.facade.config.CommonUrlConfig;
import com.wy.shop.facade.domain.IndexVo;
import com.wy.shop.facade.impl.config.ApiVersion;
import com.wy.shop.facade.request.IndexRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author : WangYB
 * @time: 2020/12/9  13:57
 *
 */
@RestController
@RequestMapping(CommonUrlConfig.INDEX_URL_PREFIX)
public class IndexFacadeImpl implements IndexFacade {

    //@ApiVersion(CommonUrlConfig.DEFAULT_VERSION)
    //@GetMapping(CommonUrlConfig.URL_FGDS_SOR_INV_EXPORT_QUERY_LIST + CommonUrlConfig.VERSION_PLACEHOLDER)
    @GetMapping(CommonUrlConfig.URL_INDEX_QUERY_PANEL_INFO)
    @ResponseBody
    @Override
    public Result<IndexVo> queryIndexPanelInfo() {
        IndexVo indexVo = new IndexVo();
        indexVo.setGoodsOnsale(1233);
        indexVo.setOrderToDelivery(12);
        indexVo.setTimestamp(new Date().getTime()/1000);
        indexVo.setUser(1234);
        return Result.success(indexVo);
    }



}
