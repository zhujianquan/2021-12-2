package com.tupu360.mybatis.mapper;

import com.tupu360.mybatis.model.UUserInfo;

public interface UUserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UUserInfo record);

    int insertSelective(UUserInfo record);

    UUserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UUserInfo record);

    int updateByPrimaryKey(UUserInfo record);

    UUserInfo selectByUid(Integer id);
}