package com.xiaoyang.mapper;

import java.util.List;

import com.xiaoyang.po.ItemsCustom;
import com.xiaoyang.po.ItemsQueryVo;

public interface ItemsMapperCustom {

	//商品的查询列表
		public List<ItemsCustom> findeItemList(ItemsQueryVo itemsQueryVo)throws Exception;
		
		//根据ID查询商品信息
		public ItemsCustom findItemsById(Integer id)throws Exception;
		
		//修改商品信息
		public void updatItemsById(Integer id,ItemsCustom itemsCustom)throws Exception;
}
