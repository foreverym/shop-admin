package com.wy.shop.facade;

import com.wy.shop.common.exception.DaoException;
import com.wy.shop.common.result.Result;
import com.wy.shop.facade.request.LoginRequest;
import com.wy.shop.facade.response.LoginResponse;

/**
 * @author : WangYB
 * @time: 2020/12/9  17:22
 */
public interface AuthFacade {

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
    public Result<LoginResponse> doLogin(LoginRequest request, String token) throws DaoException;

}
