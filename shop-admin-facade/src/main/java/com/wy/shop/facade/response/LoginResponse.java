package com.wy.shop.facade.response;

import com.wy.shop.facade.domain.UserVo;
import lombok.Data;

/**
 * @author : WangYB
 * @time: 2020/12/9  17:23
 */
@Data
public class LoginResponse {

    private UserVo userInfo;
    private String token;

}
