package com.wy.shop.facade;

import com.wy.shop.common.result.Result;
import com.wy.shop.facade.request.LoginRequest;
import com.wy.shop.facade.response.LoginResponse;

/**
 * @author : WangYB
 * @time: 2020/12/9  17:22
 */
public interface AuthFacade {

    public Result<LoginResponse> doLogin(LoginRequest request);

}
