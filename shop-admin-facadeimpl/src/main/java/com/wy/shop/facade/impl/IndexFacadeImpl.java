package com.wy.shop.facade.impl;

import com.wy.shop.facade.IndexFacade;
import com.wy.shop.facade.config.CommonUrlConfig;
import com.wy.shop.facade.domain.IndexVo;
import com.wy.shop.facade.impl.config.ApiVersion;
import com.wy.shop.facade.request.IndexRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : WangYB
 * @time: 2020/12/9  13:57
 *
 */
@RestController
@RequestMapping(value = CommonUrlConfig.INDEX_URL_PREFIX, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class IndexFacadeImpl implements IndexFacade {

    @ApiVersion(CommonUrlConfig.DEFAULT_VERSION)
    @GetMapping(CommonUrlConfig.URL_FGDS_SOR_INV_EXPORT_QUERY_LIST + CommonUrlConfig.VERSION_PLACEHOLDER)
    @Override
    public IndexVo queryIndexInfo(IndexRequest indexRequest) {
        return null;
    }

}
