package com.xiaoyang.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xiaoyang.mapper.ItemsMapper;
import com.xiaoyang.mapper.ItemsMapperCustom;
import com.xiaoyang.po.Items;
import com.xiaoyang.po.ItemsCustom;
import com.xiaoyang.po.ItemsQueryVo;
import com.xiaoyang.service.ItemsService;

public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<ItemsCustom> findeItemList(ItemsQueryVo itemsQueryVo) throws Exception {
		return itemsMapperCustom.findeItemList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
//		这里可以写Items 与 Custom扩展的一些东西方便扩展
		
		ItemsCustom itemsCustom = new ItemsCustom();
////		讲items中的信息拷贝到 itemsCustom中
		BeanUtils.copyProperties(items, itemsCustom);
		
		return   itemsCustom;
	}

	@Override
	public void updatItemsById(Integer id, ItemsCustom itemsCustom)
			throws Exception {
//		添加业务验证，对应关键的字段进行校验  
//		Service第一步处理一般都是校验处理   如果为空 抛出异常
		if (!id.equals(null)) {
			itemsCustom.setId(id);
		}
		itemsMapper.updateByPrimaryKey(itemsCustom);
		
	}

	
}
