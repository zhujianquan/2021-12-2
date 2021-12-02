package com.tupu360.mybatis.mapper;

import com.tupu360.mybatis.model.IdCard;

public interface IdCardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IdCard record);

    int insertSelective(IdCard record);

    IdCard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IdCard record);

    int updateByPrimaryKey(IdCard record);
}