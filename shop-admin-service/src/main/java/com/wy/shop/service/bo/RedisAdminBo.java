package com.wy.shop.service.bo;

import lombok.Data;

/**
 * @author : WangYB
 * @time: 2020/12/10  19:59
 */

public class RedisAdminBo {

    private Integer id;
    private String username;
    private String lastLoginIp;
    private Long lastLoginTime;
    private Integer is_delete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    public RedisAdminBo() {
    }

    public RedisAdminBo(Integer id, String username, String lastLoginIp, Long lastLoginTime, Integer is_delete) {
        this.id = id;
        this.username = username;
        this.lastLoginIp = lastLoginIp;
        this.lastLoginTime = lastLoginTime;
        this.is_delete = is_delete;
    }

    @Override
    public String toString() {
        return "RedisAdminBo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", is_delete=" + is_delete +
                '}';
    }

}
