package com.wy.shop.facade;


import com.wy.shop.common.result.Result;
import com.wy.shop.facade.domain.IndexVo;
import com.wy.shop.facade.request.IndexRequest;

public interface IndexFacade {

    /**
     *
     * 根据国家和税的种类获取政府支持的税号<br>
     *
     * @see com.pracbiz.pbx.b2b.facade.tax.common.config.TaxCommonUrlConfig#URL_COMM_TAX_GOV_QUERY_LIST
     *
     * @author
     * @see com.wy.shop.facade.request.IndexRequest
     * @param indexRequest <br>
     *            ctryCode (required)<br>
     *            taxType (required)<br>
     * @see com.wy.shop.facade.domain.IndexVo
     * @return 根据接口文档定义的JSON格式响应信息<br>
     *         retCode(返回码)<br>
     *         retCode = 000000 SUCCESS<br>
     *         retCode = 100001 Invalid Parameter<br>
     *         retCode = 999999 System Error<br>
     *         retMsg<br>
     *         list<br>
     *         --taxCode<br>
     *         --taxRate<br>
     *         --taxDesc<br>
     */
    public Result<IndexVo> queryIndexPanelInfo();


}
