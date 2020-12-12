package com.wy.shop.facade;


import com.wy.shop.common.result.Result;
import com.wy.shop.facade.domain.IndexVo;
import com.wy.shop.facade.request.IndexRequest;
import com.wy.shop.facade.response.IndexMainResponse;

public interface IndexFacade {

    /**
     *
     * 授权登录
     *
     * @see com.wy.shop.facade.config.CommonUrlConfig#URL_AUTH_CHECK_LOGIN
     *
     * @author
     * @see com.wy.shop.facade.request.IndexRequest
     * @param request <br>
     *            ctryCode (required)<br>
     *            taxType (required)<br>
     * @param token
     * @see com.wy.shop.facade.domain.IndexVo
     * @return 根据接口文档定义的JSON格式响应信息<br>
     *         retCode(返回码)<br>
     *         retCode = 000000 SUCCESS<br>
     *         retCode = 100001 Invalid Parameter<br>
     *         retCode = 999999 System Error<br>
     *         retMsg<br>
     *         response<br>
     *         --taxCode<br>
     *         --taxRate<br>
     *         --taxDesc<br>
     */
    public Result<IndexVo> queryIndexPanelInfo();


    public Result<IndexMainResponse> queryIndexMainInfo(Integer pindex);


}
