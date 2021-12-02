package com.tupu360.mybatis.model;

import lombok.Data;

import java.util.Date;


@Data
public class UUserInfo {
    private Integer id;

    private String userName;

    private String phone;

    private String loginPassword;

    private String dealPassword;

    private String email;

    private String qq;

    private String wechat;

    private Boolean userType;

    private Boolean isVip;

    private Boolean isLock;

    private Date createTime;

    private Date lockTime;

    private Integer loginCount;

    private String inviteCode;

    private IdCard idCard;

    public UUserInfo(String userName){
        this.userName = userName;
    }

}