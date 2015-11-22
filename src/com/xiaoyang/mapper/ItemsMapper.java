package com.xiaoyang.mapper;

import com.xiaoyang.po.Items;

public interface ItemsMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Items record);

    Items selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Items record);
    
    

}