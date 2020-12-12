package com.wy.shop.facade.domain;

import lombok.Data;

/**
 * @author : WangYB
 * @time: 2020/12/12  09:02
 */
@Data
public class IndexMainVo {

    private Integer id;
    private String avatar;
    private Integer gender;
    private String nickName;
    private String register_time;
    private String last_login_time;

}
