package com.wy.shop.facade.impl;

import com.wy.shop.common.exception.DaoException;
import com.wy.shop.common.result.CodeMsg;
import com.wy.shop.common.result.Result;
import com.wy.shop.facade.AuthFacade;
import com.wy.shop.facade.config.CommonUrlConfig;
import com.wy.shop.facade.domain.IndexVo;
import com.wy.shop.facade.domain.UserVo;
import com.wy.shop.facade.request.LoginRequest;
import com.wy.shop.facade.response.LoginResponse;
import com.wy.shop.service.AdminService;
import com.wy.shop.service.bo.AdminBo;
import com.wy.shop.service.bo.LoginReqBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : WangYB
 * @time: 2020/12/9  17:27
 */
@RequestMapping(CommonUrlConfig.AUTH_URL_PREFIX)
@RestController
public class AuthFacadeImpl implements AuthFacade {

    public static final Logger logger = LoggerFactory.getLogger(AuthFacadeImpl.class);

    @Autowired
    private AdminService adminService;

    @PostMapping(CommonUrlConfig.URL_AUTH_CHECK_LOGIN)
    @ResponseBody
    @Override
    public Result<LoginResponse> doLogin(@RequestBody LoginRequest request, @RequestHeader("X-Nideshop-Token") String token) throws DaoException {
        LoginReqBo loginReqBo = new LoginReqBo();
        BeanUtils.copyProperties(request, loginReqBo);
        logger.info(">>>>>>>>>" + loginReqBo + token);
        AdminBo adminBo = null;
        adminBo = adminService.login(loginReqBo, token);
        LoginResponse response = new LoginResponse();
        UserVo userVo = new UserVo();
        userVo.setId(adminBo.getId());
        userVo.setUsername(adminBo.getUsername());
        response.setUserInfo(userVo);
        response.setToken(adminBo.getToken());
        return Result.success(response);
    }

}
