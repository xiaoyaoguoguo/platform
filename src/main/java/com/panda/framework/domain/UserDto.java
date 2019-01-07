package com.panda.framework.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author jamie
 * @ClassName: UserDto
 * @Description: 登录用户类
 * @data 2019-01-07 17:30
 **/
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1795764812229535955L;

    private Integer id;
    private String userId;
    private String name;
    private String username;
    private String email;
    private String mobile;
    private String photo;
    private String openId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
