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
//		�������дItems �� Custom��չ��һЩ����������չ
		
		ItemsCustom itemsCustom = new ItemsCustom();
////		��items�е���Ϣ������ itemsCustom��
		BeanUtils.copyProperties(items, itemsCustom);
		
		return   itemsCustom;
	}

	@Override
	public void updatItemsById(Integer id, ItemsCustom itemsCustom)
			throws Exception {
//		���ҵ����֤����Ӧ�ؼ����ֶν���У��  
//		Service��һ������һ�㶼��У�鴦��   ���Ϊ�� �׳��쳣
		if (!id.equals(null)) {
			itemsCustom.setId(id);
		}
		itemsMapper.updateByPrimaryKey(itemsCustom);
		
	}

	
}
