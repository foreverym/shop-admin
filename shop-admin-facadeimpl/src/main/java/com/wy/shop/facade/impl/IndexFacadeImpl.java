package com.wy.shop.facade.impl;

import com.wy.shop.common.result.Result;
import com.wy.shop.facade.IndexFacade;
import com.wy.shop.facade.config.CommonUrlConfig;
import com.wy.shop.facade.domain.IndexMainVo;
import com.wy.shop.facade.domain.IndexVo;
import com.wy.shop.facade.impl.config.ApiVersion;
import com.wy.shop.facade.request.IndexRequest;
import com.wy.shop.facade.response.IndexMainResponse;
import com.wy.shop.service.IndexService;
import com.wy.shop.service.bo.IndexMainBo;
import com.wy.shop.service.bo.PanelBo;
import com.wy.shop.service.bo.UserIndexMainBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : WangYB
 * @time: 2020/12/9  13:57
 *
 */
@RestController
@RequestMapping(CommonUrlConfig.INDEX_URL_PREFIX)
public class IndexFacadeImpl implements IndexFacade {

    public static final Logger logger = LoggerFactory.getLogger(IndexFacadeImpl.class);

    @Autowired
    private IndexService indexService;

    //@ApiVersion(CommonUrlConfig.DEFAULT_VERSION)
    //@GetMapping(CommonUrlConfig.URL_FGDS_SOR_INV_EXPORT_QUERY_LIST + CommonUrlConfig.VERSION_PLACEHOLDER)
    @GetMapping(CommonUrlConfig.URL_INDEX_QUERY_PANEL_INFO)
    @ResponseBody
    @Override
    public Result<IndexVo> queryIndexPanelInfo() {
        PanelBo panelBo = indexService.queryIndexPanelInfo();
        IndexVo indexVo = new IndexVo();
        BeanUtils.copyProperties(panelBo, indexVo);
        indexVo.setTimestamp(new Date().getTime()/1000);
        return Result.success(indexVo);
    }

    @GetMapping(CommonUrlConfig.URL_INDEX_MAIN_INFO)
    @ResponseBody
    @Override
    public Result<IndexMainResponse> queryIndexMainInfo(Integer pindex) {
        final IndexMainBo indexMainBo = indexService.getIndexMainInfo(pindex);
        IndexMainResponse indexMainResponse = new IndexMainResponse();
        List<UserIndexMainBo> newData = indexMainBo.getOldData();
        List<IndexMainVo> collect = newData.stream().map(userIndexMainBo -> {
            IndexMainVo indexMainVo = new IndexMainVo();
            BeanUtils.copyProperties(userIndexMainBo, indexMainVo);
            logger.info("??????????????????" + indexMainVo);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
            String formatLastLoginTime = simpleDateFormat.format(userIndexMainBo.getLast_login_time()*1000);
            String formatRegisterTime = simpleDateFormat.format(userIndexMainBo.getRegister_time()*1000);
            indexMainVo.setLast_login_time(formatLastLoginTime);
            indexMainVo.setRegister_time(formatRegisterTime);
            return indexMainVo;
        }).collect(Collectors.toList());
        BeanUtils.copyProperties(indexMainBo, indexMainResponse);
        indexMainResponse.setNewData(collect);
        return Result.success(indexMainResponse);
    }




}
