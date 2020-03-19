package com.lft.mapper;

import java.util.List;

import com.lft.domain.UserAb;

public interface UserAbMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserAb record);

    int insertSelective(UserAb record);

    UserAb selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserAb record);

    int updateByPrimaryKey(UserAb record);
    
    
    List<UserAb>selectAll(String id,UserAb ab);
}