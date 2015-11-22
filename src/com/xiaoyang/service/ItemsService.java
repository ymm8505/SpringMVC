package com.xiaoyang.service;

import java.util.List;

import com.xiaoyang.po.ItemsCustom;
import com.xiaoyang.po.ItemsQueryVo;

public interface ItemsService {

	//��Ʒ�Ĳ�ѯ�б�
	public List<ItemsCustom> findeItemList(ItemsQueryVo itemsQueryVo)throws Exception;
	
	//����ID��ѯ��Ʒ��Ϣ
	public ItemsCustom findItemsById(Integer id)throws Exception;
	
	//�޸���Ʒ��Ϣ
	public void updatItemsById(Integer id,ItemsCustom itemsCustom)throws Exception;
	
}