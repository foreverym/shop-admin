package com.wy.shop.facade.impl;

import com.wy.shop.common.result.Result;
import com.wy.shop.facade.AuthFacade;
import com.wy.shop.facade.domain.IndexVo;
import com.wy.shop.facade.request.LoginRequest;
import com.wy.shop.facade.response.LoginResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author : WangYB
 * @time: 2020/12/9  17:27
 */
public class AuthFacadeImpl implements AuthFacade {

    @Override
    public Result<LoginResponse> doLogin(@RequestBody LoginRequest request) {
        IndexVo indexVo = new IndexVo();

        BeanUtils.copyProperties(request, indexVo);
        return null;

    }

}
