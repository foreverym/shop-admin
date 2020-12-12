package com.wy.shop.service.bo;

import lombok.Data;

/**
 * @author : WangYB
 * @time: 2020/12/10  15:04
 */
@Data
public class LoginReqBo {

    private String username;
    private String password;
    private String token;

}
